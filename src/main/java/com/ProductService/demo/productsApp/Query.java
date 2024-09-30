package com.ProductService.demo.productsApp;

public interface Query<I, O> {
    O execute(I input);
}