package com.marketplace.marketplace_api.service;

import com.marketplace.marketplace_api.dto.ProductDTO;
import com.marketplace.marketplace_api.entity.Product;
import com.marketplace.marketplace_api.entity.User;
import com.marketplace.marketplace_api.exception.ProductNotFoundException;
import com.marketplace.marketplace_api.exception.UserNotFoundException;
import com.marketplace.marketplace_api.repository.ProductRepository;
import com.marketplace.marketplace_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
       this.userRepository = userRepository;
    }

    public ProductDTO getProductById(Long id)  {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        String name = (product.getSeller() != null)? product.getSeller().getUsername() : "Anonymous";
        return new ProductDTO(product.getName(), product.getPrice(), name, product.getDescription(), product.getStock());
    }

    public ProductDTO createProduct(ProductDTO productDTO)  {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        User seller = userRepository.findById(productDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        product.setSeller(seller);
        productRepository.save(product);
        return new ProductDTO(product.getName(), product.getPrice(), product.getSeller().getUsername(), product.getDescription(), product.getStock());
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDTO(
                        product.getName(),
                        product.getPrice(),
                        (product.getSeller() != null)? product.getSeller().getUsername() : "Anonymous",
                        product.getDescription(),
                        product.getStock()
                ))
                .toList();
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        User seller = userRepository.findById(productDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        product.setSeller(seller);
        productRepository.save(product);
        return new ProductDTO(product.getName(), product.getPrice(), product.getSeller().getUsername(), product.getDescription(), product.getStock());
    }
}
