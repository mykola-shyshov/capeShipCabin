package com.cape.api.assemblers;

import com.cape.api.dto.CaptainOrderTO;
import com.cape.dao.documents.Order;

import javax.inject.Named;

@Named
public class CaptainOrderAssembler {

    public CaptainOrderTO toResource( Order order ) {
        return new CaptainOrderTO(
               order.getName(),
               order.getPhone(),
               order.getProductId(),
               order.getCustomOrderDescription(),
               order.getPrice(),
               order.getOrderStatus(),
               order.getRemark()
        );
    }

    public Order fromResource( CaptainOrderTO captainOrderTO ) {
        return new Order(
              captainOrderTO.getName(),
              captainOrderTO.getPhone(),
              captainOrderTO.getProductId(),
              captainOrderTO.getCustomOrderDescription(),
              captainOrderTO.getPrice(),
              captainOrderTO.getOrderStatus(),
              captainOrderTO.getRemark()
        );
    }
}
