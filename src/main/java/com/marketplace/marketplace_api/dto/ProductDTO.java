package com.marketplace.marketplace_api.dto;

public class ProductDTO {
    private String name;
    private double price;
    private String sellerName;
    private Long userId;
    private String description;
    private int stock;

    public ProductDTO() {
    }

    public ProductDTO(String name, double price,  String sellerName) {
        this.name = name;
        this.price = price;
        this.sellerName = sellerName;
    }

    public ProductDTO(String name, double price, String sellerName, String description, int stock) {
        this.name = name;
        this.price = price;
        this.sellerName = sellerName;
        this.description = description;
        this.stock = stock;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

}
