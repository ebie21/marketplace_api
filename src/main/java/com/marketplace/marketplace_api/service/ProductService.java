package com.marketplace.marketplace_api.service;


import com.marketplace.marketplace_api.dto.ProductDTO;
import com.marketplace.marketplace_api.entity.Category;
import com.marketplace.marketplace_api.entity.Product;
import com.marketplace.marketplace_api.entity.User;
import com.marketplace.marketplace_api.exception.*;
import com.marketplace.marketplace_api.repository.CategoryRepository;
import com.marketplace.marketplace_api.repository.ProductRepository;
import com.marketplace.marketplace_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository,  CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    private ProductDTO mapToDTO(Product product){
        String name = (product.getUser() != null)? product.getUser().getUsername() : "Anonymous";
        Long userId = product.getUser() != null? product.getUser().getId() : null;
        Long categoryId = product.getCategory() != null? product.getCategory().getId() : null;
        return new ProductDTO(
                product.getName(),
                product.getPrice(),
                name,
                product.getDescription(),
                product.getStock(),
                userId,
                categoryId

        );
    }

    public ProductDTO getProductById(long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found!"));
        return mapToDTO(product);
    }

    public List<ProductDTO> getAllProducts(){
       return productRepository.findAll()
               .stream()
               .map(this::mapToDTO)
               .toList();
    }

    public ProductDTO createProduct(ProductDTO productDTO){
        Product product = new Product();
        if (productDTO.getPrice() <= 0){
            throw new InvalidProductException("Price must be greater than 0");
        }
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        User user = userRepository.findById(productDTO.getUserId()).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
        product.setUser(user);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
        product.setCategory(category);
        return mapToDTO(productRepository.save(product));
    }

    public ProductDTO updateProduct(long id, ProductDTO productDTO) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found!"));
        if (!updatedProduct.getUser().getId().equals(productDTO.getUserId())){
            throw new UnauthorizedAccessException("Unauthorized Access");
        }
        updatedProduct.setName(productDTO.getName());
        updatedProduct.setPrice(productDTO.getPrice());
        updatedProduct.setDescription(productDTO.getDescription());
        updatedProduct.setStock(productDTO.getStock());
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new CategoryNotFoundException("Category not found!"));
        updatedProduct.setCategory(category);
        return mapToDTO(productRepository.save(updatedProduct));
    }

    public void deleteProduct(long id, long userId){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found!"));
        if (!product.getUser().getId().equals(userId)){
            throw new UnauthorizedAccessException("Unauthorized Access");
        }
        productRepository.deleteById(id);
    }

}