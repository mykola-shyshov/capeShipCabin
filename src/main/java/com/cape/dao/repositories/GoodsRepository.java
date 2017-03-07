package com.cape.dao.repositories;

import com.cape.dao.documents.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GoodsRepository extends PagingAndSortingRepository<Product, String> {
}
