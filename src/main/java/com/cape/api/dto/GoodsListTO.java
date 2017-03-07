package com.cape.api.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsListTO {
    private List<ProductTO> items = new ArrayList<>();

    public GoodsListTO( List<ProductTO> items ) {
        this.items.addAll( items );
    }

    public List<ProductTO> getItems() {
        return Collections.unmodifiableList( items );
    }
}
