package com.cape.api.assemblers;

import com.cape.api.dto.GoodsListTO;
import com.cape.dao.documents.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoodsAssembler {

    @Autowired
    private ProductAssembler productAssembler;

    public GoodsListTO toResource( List<Product> goods ) {
        return new GoodsListTO(
             goods.stream()
                  .map( productAssembler::toResource )
                  .collect( Collectors.toList() )
        );
    }
}
