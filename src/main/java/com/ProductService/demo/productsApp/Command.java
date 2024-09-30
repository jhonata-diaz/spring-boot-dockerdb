package com.ProductService.demo.productsApp;

public interface Command<I, O> {
    O execute(I input);
}
