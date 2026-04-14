package com.marketplace.marketplace_api.repository;

import com.marketplace.marketplace_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
