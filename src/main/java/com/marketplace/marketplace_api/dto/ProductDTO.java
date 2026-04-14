package com.marketplace.marketplace_api.dto;

import com.marketplace.marketplace_api.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank(message = "Product cant be empty")
    private String name;
    @Min(value = 0, message = "Price cannot be negative")
    private double price;
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Description is required")
    private String description;
    @Min(value = 1, message = "Stock must be at least 1")
    private int stock;
    @NotNull(message = "User ID is required")
    private Long userId;
    @NotNull(message = "Category ID is required")
    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(String name, double price, String username) {
        this.name = name;
        this.price = price;
        this.username = username;
    }

    public ProductDTO(String name, double price, String username, String description, int stock) {
        this.name = name;
        this.price = price;
        this.username = username;
        this.description = description;
        this.stock = stock;

    }

    public ProductDTO(String name, double price, String username, String description, int stock, Long userId, Long categoryId) {
        this.name = name;
        this.price = price;
        this.username = username;
        this.description = description;
        this.stock = stock;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}