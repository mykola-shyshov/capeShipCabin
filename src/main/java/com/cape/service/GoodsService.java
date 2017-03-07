package com.cape.service;

import com.cape.dao.documents.Product;
import com.cape.dao.repositories.GoodsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<Product> list() {
        return Lists.newArrayList( goodsRepository.findAll() );
    }
}
