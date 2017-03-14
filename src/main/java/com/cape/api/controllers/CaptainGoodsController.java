package com.cape.api.controllers;

import com.cape.api.assemblers.CaptainGoodsAssembler;
import com.cape.api.dto.CaptainGoodsListTO;
import com.cape.api.dto.CaptainProductTO;
import com.cape.service.CaptainGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping( "/v{er}/captain/goods" )
public class CaptainGoodsController {

    private final CaptainGoodsAssembler captainGoodsAssembler;
    private final CaptainGoodsService captainGoodsService;

    @Inject
    public CaptainGoodsController(
           CaptainGoodsAssembler captainGoodsAssembler,
           CaptainGoodsService captainGoodsService
    ) {
        this.captainGoodsAssembler = captainGoodsAssembler;
        this.captainGoodsService = captainGoodsService;
    }

    @GetMapping( "/" )
    public CaptainGoodsListTO getGoods() {
        return captainGoodsAssembler.toResource(
              captainGoodsService.list()
        );
    }

    @PutMapping( "/" )
    public CaptainProductTO updateProduct(
           @RequestBody CaptainProductTO captainProductTO
    ) {
        return captainGoodsAssembler.toResource(
            captainGoodsService.updateProduct(
                  captainGoodsAssembler.fromResource( captainProductTO )
            )
        );
    }
}
