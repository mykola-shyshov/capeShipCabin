package com.cape.api.assemblers;

import com.cape.api.dto.OrderTO;
import com.cape.dao.documents.Order;

import javax.inject.Named;

@Named
public class OrderAssembler {

    public OrderTO toResource( Order order ) {
        return new OrderTO(
              order.getId(),
              order.getName(),
              order.getPhone(),
              order.getProductId(),
              order.getCustomOrderDescription()
        );
    }
}
