package com.cape.api.controllers;


import com.cape.api.assemblers.GoodsAssembler;
import com.cape.api.dto.GoodsListTO;
import com.cape.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping( "/v{er}/goods" )
public class GoodsController {

    private final GoodsAssembler goodsAssembler;
    private final GoodsService goodsService;

    @Inject
    public GoodsController(
            GoodsAssembler goodsAssembler,
            GoodsService goodsService
    ) {
        this.goodsAssembler = goodsAssembler;
        this.goodsService = goodsService;
    }

    @GetMapping( "/" )
    public GoodsListTO getGoods() {
        return goodsAssembler.toResource(
              goodsService.list()
        );
    }
}
