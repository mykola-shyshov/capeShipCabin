package com.cape.api.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaptainGoodsListTO {

    private List<CaptainProductTO> items = new ArrayList<>();

    public CaptainGoodsListTO( List<CaptainProductTO> items ) {
        this.items.addAll( items );
    }

    public List<CaptainProductTO> getItems() {
        return Collections.unmodifiableList( items );
    }
}
