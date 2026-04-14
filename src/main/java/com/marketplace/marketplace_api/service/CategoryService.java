package com.marketplace.marketplace_api.service;

import com.marketplace.marketplace_api.dto.CategoryDTO;
import com.marketplace.marketplace_api.entity.Category;
import com.marketplace.marketplace_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getCategoryName());

        // THE SAVE: This is what makes it "stick" in MySQL
        Category savedCategory = categoryRepository.save(category);

        // THE MAP: Return the DTO, keep the Entity private
        return new CategoryDTO(savedCategory.getId(), savedCategory.getName());
    }
}
