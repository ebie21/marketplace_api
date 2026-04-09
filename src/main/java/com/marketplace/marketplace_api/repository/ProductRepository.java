package com.marketplace.marketplace_api.repository;

import com.marketplace.marketplace_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
