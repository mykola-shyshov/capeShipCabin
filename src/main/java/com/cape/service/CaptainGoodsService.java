package com.cape.service;

import com.cape.dao.documents.Product;
import com.cape.dao.repositories.GoodsRepository;
import com.google.common.collect.Lists;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CaptainGoodsService {

    private final GoodsRepository goodsRepository;

    @Inject
    public CaptainGoodsService( GoodsRepository goodsRepository ) {
        this.goodsRepository = goodsRepository;
    }

    public List<Product> list() {
        return Lists.newArrayList( goodsRepository.findAll() );
    }

    public Product updateProduct( Product product ) {
        return goodsRepository.save( product );
    }
}
