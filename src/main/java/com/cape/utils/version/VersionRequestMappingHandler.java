package com.cape.utils.version;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionRequestMappingHandler extends RequestMappingHandlerMapping {

    private static final String VERSION_PATH_PREFIX = "/v";
    private static final Pattern versionedLatestPattern = Pattern.compile( "^/v\\{.+?\\}" );
    private static final Pattern versionedWithNumberPattern = Pattern.compile( "^/v(\\d+)" );
    private AntPathMatcher pathMatcher = new AntPathMatcher();
    private Map<String, TreeSet<Integer>> versionMappings;

    @Override
    protected void initHandlerMethods() {
        super.initHandlerMethods();
        try {
            this.versionMappings = detectVersions( getEndpoints() );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
    @Override
    protected HandlerMethod lookupHandlerMethod( String lookupPath, HttpServletRequest request )
          throws Exception {
        String correspondPath;
        if ( !isVersionedWithNumberPath( lookupPath ) ) {
            HandlerMethod handler = super.lookupHandlerMethod( lookupPath, request );
            if ( handler != null ) {
                return handler;
            }
            correspondPath = findVersionedLatestPath( lookupPath );
            if ( correspondPath == null ) {
                return null;
            }
        } else {
            Integer specifiedVersion = extractVersionNumber( lookupPath );
            Integer correspondVersion = findCorrespondVersion( lookupPath );
            if ( specifiedVersion.equals( correspondVersion ) ||
                       correspondVersion == null ) {
                return super.lookupHandlerMethod( lookupPath, request );
            }
            correspondPath = VERSION_PATH_PREFIX + correspondVersion +
                                   extractNotVersionedPath( lookupPath );
        }
        request = new VersionedRequest( request, correspondPath );
        return super.lookupHandlerMethod( correspondPath, request );
    }

    @Nullable
    private String findVersionedLatestPath( String path ) {
        for ( String versionedEndpoint : versionMappings.keySet() ) {
            if ( versionedEndpoint.contains( path ) ) {
                return versionedEndpoint;
            }
        }
        return null;
    }

    private Map<String, TreeSet<Integer>> detectVersions( List<String> endpoints ) {
        List<String> versionedLatestEndpoints = new ArrayList<>();
        List<String> versionedWithNumberEndpoints = new ArrayList<>();
        for ( String mapping : endpoints ) {
            if ( isVersionedPath( mapping ) ) {
                versionedLatestEndpoints.add( mapping );
            }
            if ( isVersionedWithNumberPath( mapping ) ) {
                versionedWithNumberEndpoints.add( mapping );
            }
        }
        Map<String, TreeSet<Integer>> versionMappings = new HashMap<>();
        Set<String> processed = new HashSet<>();
        for ( String versionedPath : versionedLatestEndpoints ) {
            String basePathWithoutVersion = extractNotVersionedPath( versionedPath );
            for ( String path : versionedWithNumberEndpoints ) {
                String pathWithoutVersion = extractNotVersionedPath( path );
                if ( pathMatcher.match( versionedPath, path )
                           && basePathWithoutVersion.equals( pathWithoutVersion )
                           && ( !processed.contains( path ) ) ) {
                    int version = extractVersionNumber( path );
                    TreeSet<Integer> versions = versionMappings.get( versionedPath );
                    if ( versions == null ) {
                        versions = new TreeSet<>();
                    }
                    versions.add( version );
                    versionMappings.put( versionedPath, versions );
                    processed.add( path );
                }
            }
        }
        // if latest is not specified
        for ( String path : versionedWithNumberEndpoints ) {
            if ( !processed.contains( path ) ) {
                int version = extractVersionNumber( path );
                path = "/v{ver}" + extractNotVersionedPath( path );
                TreeSet<Integer> versions = new TreeSet<>();
                versions.add( version );
                versionMappings.put( path, versions );
            }
        }
        return versionMappings;
    }

    private List<String> getEndpoints() {
        List<String> result = new ArrayList<>();
        for ( RequestMappingInfo requestMappingInfo : getHandlerMethods().keySet() ) {
            result.addAll( requestMappingInfo.getPatternsCondition()
                                             .getPatterns() );
        }
        return result;
    }

    @Nullable
    private Integer findCorrespondVersion( String lookupPath ) {
        int version = extractVersionNumber( lookupPath );
        Integer correspondVersion = null;
        for ( String versionedEndpoint : versionMappings.keySet() ) {
            if ( pathMatcher.match( versionedEndpoint, lookupPath ) ) {
                TreeSet<Integer> versions = versionMappings.get( versionedEndpoint );
                correspondVersion = versions.ceiling( version );
                break;
            }
        }
        return correspondVersion;
    }
    private boolean isVersionedPath( String path ) {
        return versionedLatestPattern.matcher( path ).find();
    }
    private boolean isVersionedWithNumberPath( String path ) {
        return versionedWithNumberPattern.matcher( path ).find();
    }
    private String extractNotVersionedPath( String versionedPath ) {
        Matcher matcher = versionedLatestPattern.matcher( versionedPath );
        String path;
        if ( matcher.find() ) {
            path = versionedPath.substring( matcher.end() );
        } else {
            matcher = versionedWithNumberPattern.matcher( versionedPath );
            if ( !matcher.find() ) {
                throw new IllegalArgumentException( "Incorrect versioned path: " + versionedPath );
            }
            path = versionedPath.substring( matcher.end() );
        }
        return path;
    }
    private int extractVersionNumber( String versionedPath ) {
        Matcher matcher = versionedWithNumberPattern.matcher( versionedPath );
        if ( !matcher.find() ) {
            throw new IllegalArgumentException( "Incorrect versioned path: " + versionedPath );
        }
        return Integer.parseInt( matcher.group( 1 ) );
    }
}
