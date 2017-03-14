package com.cape.api.controllers;

import com.cape.api.assemblers.CaptainOrdersAssembler;
import com.cape.api.dto.CaptainOrderTO;
import com.cape.api.dto.CaptainOrdersListTO;
import com.cape.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping( "/v{er}/captain/orders" )
public class CaptainOrdersController {

    private final OrdersService ordersService;
    private final CaptainOrdersAssembler captainOrdersAssembler;

    @Inject
    public CaptainOrdersController(
            OrdersService ordersService,
            CaptainOrdersAssembler captainOrdersAssembler
    ) {
        this.ordersService = ordersService;
        this.captainOrdersAssembler = captainOrdersAssembler;
    }

    @GetMapping( "/" )
    public CaptainOrdersListTO getOrders() {
        return captainOrdersAssembler.toResource(
              ordersService.list()
        );
    }

    @PutMapping( "/" )
    public void updateOrder(
          @RequestBody CaptainOrderTO captainOrderTO
    ) {
        ordersService.updateOrder(
              captainOrdersAssembler.fromResource( captainOrderTO )
        );
    }
}
