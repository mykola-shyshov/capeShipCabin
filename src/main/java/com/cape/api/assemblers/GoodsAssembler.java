package com.cape.api.assemblers;

import com.cape.api.dto.BuyProductTO;
import com.cape.api.dto.GoodsListTO;
import com.cape.dao.documents.Order;
import com.cape.dao.documents.Product;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class GoodsAssembler {

    private final ProductAssembler productAssembler;

    @Inject
    public GoodsAssembler( ProductAssembler productAssembler ) {
        this.productAssembler = productAssembler;
    }

    public GoodsListTO toResource( List<Product> goods ) {
        return new GoodsListTO(
             goods.stream()
                  .map( productAssembler::toResource )
                  .collect( Collectors.toList() )
        );
    }

    public Order fromResource( BuyProductTO buyGoodsTO ) {
        return new Order(
              buyGoodsTO.getName(),
              buyGoodsTO.getPhone(),
              buyGoodsTO.getProductId(),
              buyGoodsTO.getCustomOrderDescription()
        );
    }
}
