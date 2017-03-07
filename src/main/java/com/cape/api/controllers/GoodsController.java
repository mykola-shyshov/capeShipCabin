package com.cape.api.controllers;


import com.cape.api.assemblers.GoodsAssembler;
import com.cape.api.dto.GoodsListTO;
import com.cape.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/v{er}/goods" )
public class GoodsController {

    @Autowired
    private GoodsAssembler goodsAssembler;

    @Autowired
    private GoodsService goodsService;

    @GetMapping( "/" )
    public GoodsListTO getGoods() {
        return goodsAssembler.toResource(
              goodsService.list()
        );
    }

}
