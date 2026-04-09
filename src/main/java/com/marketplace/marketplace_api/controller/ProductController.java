package com.marketplace.marketplace_api.controller;

import com.marketplace.marketplace_api.dto.ProductDTO;
import com.marketplace.marketplace_api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

}
