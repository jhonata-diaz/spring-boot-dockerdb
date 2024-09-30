package com.ProductService.demo.productsApp.ErrorHandle;



public class ProductBadRequestException extends RuntimeException{


    public ProductBadRequestException(String message) {
        super(message);
    }
}

