package com.cape.service;

import com.cape.dao.documents.Order;
import com.cape.dao.repositories.OrderRepository;
import com.google.common.collect.Lists;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrdersService {

    private final OrderRepository orderRepository;

    @Inject
    public OrdersService( OrderRepository orderRepository ) {
        this.orderRepository = orderRepository;
    }

    public List<Order> list() {
        return Lists.newArrayList( orderRepository.findAll() );
    }

    public Order buyProduct( Order order ) {
        return orderRepository.save( order );
    }

    public void updateOrder( Order order ) {
        orderRepository.save( order );
    }
}
