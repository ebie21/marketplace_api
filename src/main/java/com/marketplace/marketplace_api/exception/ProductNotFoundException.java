package com.marketplace.marketplace_api.exception;

public class ProductNotFoundException extends ResourceNotFoundException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
