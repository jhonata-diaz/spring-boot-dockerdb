package com.ProductService.demo.productsApp;


import com.ProductService.demo.productsApp.ErrorHandle.ProductNotFoundException;
import com.ProductService.demo.productsApp.Query;
import com.ProductService.demo.productsApp.Product;
import com.ProductService.demo.productsApp.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductByIdQuery implements Query<Integer, Optional<Product>> {
    private final ProductRepository productRepository;

    public GetProductByIdQuery(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> execute(Integer input) {

        Optional<Product> data=productRepository.findById(input);
        if (data.isPresent()){
            return data;
        }

        throw new ProductNotFoundException();
        //throw new RuntimeException("product id dont exist");
    }
}