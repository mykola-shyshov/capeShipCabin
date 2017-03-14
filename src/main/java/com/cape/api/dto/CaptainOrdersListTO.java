package com.cape.api.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaptainOrdersListTO {

    private List<CaptainOrderTO> items = new ArrayList<>();

    public CaptainOrdersListTO( List<CaptainOrderTO> items ) {
        this.items = items;
    }

    public List<CaptainOrderTO> getItems() {
        return Collections.unmodifiableList( items );
    }
}
