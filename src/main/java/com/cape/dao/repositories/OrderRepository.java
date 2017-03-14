package com.cape.dao.repositories;

import com.cape.dao.documents.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
}
