package com.cape.api.assemblers;

import com.cape.api.dto.CaptainOrderTO;
import com.cape.api.dto.CaptainOrdersListTO;
import com.cape.dao.documents.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class CaptainOrdersAssembler {

    private final CaptainOrderAssembler captainOrderAssembler;

    @Inject
    public CaptainOrdersAssembler( CaptainOrderAssembler captainOrderAssembler ) {
        this.captainOrderAssembler = captainOrderAssembler;
    }

    public CaptainOrdersListTO toResource( List<Order> orders ) {
        return new CaptainOrdersListTO(
                orders.stream().map( captainOrderAssembler::toResource ).collect( Collectors.toList() )
        );
    }

    public Order fromResource( CaptainOrderTO orderTO ) {
        return new Order(
            orderTO.getName(),
            orderTO.getPhone(),
            orderTO.getProductId(),
            orderTO.getCustomOrderDescription()
        );
    }
}
