package com.cape.api.controllers;


import com.cape.api.assemblers.GoodsAssembler;
import com.cape.api.assemblers.OrderAssembler;
import com.cape.api.dto.BuyProductTO;
import com.cape.api.dto.OrderTO;
import com.cape.service.OrdersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping( "/v{er}/orders" )
public class OrdersController {

    private final OrderAssembler orderAssembler;
    private final GoodsAssembler goodsAssembler;
    private final OrdersService ordersService;

    @Inject
    public OrdersController(
             OrderAssembler orderAssembler,
             GoodsAssembler goodsAssembler,
             OrdersService ordersService
    ) {
        this.orderAssembler = orderAssembler;
        this.goodsAssembler = goodsAssembler;
        this.ordersService = ordersService;
    }

    @PostMapping( "/" )
    public OrderTO newOrder(
             @RequestBody BuyProductTO buyProductTO
    ) {
        return orderAssembler.toResource(
              ordersService.buyProduct(
                    goodsAssembler.fromResource( buyProductTO )
              )
        );
    }
}
