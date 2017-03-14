package com.cape.api.assemblers;

import com.cape.api.dto.CaptainGoodsListTO;
import com.cape.api.dto.CaptainProductTO;
import com.cape.dao.documents.Product;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class CaptainGoodsAssembler {

    public CaptainGoodsListTO toResource( List<Product> products ) {
        return new CaptainGoodsListTO(
              products.stream().map( this::toResource ).collect( Collectors.toList() )
        );
    }

    public CaptainProductTO toResource( Product product ) {
        return new CaptainProductTO(
              product.getId(),
              product.getName(),
              product.getPrice(),
              product.getDescription(),
              product.getImageUrl(),
              product.getLikes(),
              product.getMargin(),
              product.getDistribution()
        );
    }

    public Product fromResource( CaptainProductTO productTO ) {
        return new Product(
              productTO.getId(),
              productTO.getName(),
              productTO.getPrice(),
              productTO.getDescription(),
              productTO.getImageUrl(),
              productTO.getMargin(),
              productTO.getDescription(),
              productTO.getLikes()
        );
    }
}
