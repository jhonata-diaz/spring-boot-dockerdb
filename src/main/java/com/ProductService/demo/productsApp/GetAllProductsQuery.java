package com.ProductService.demo.productsApp;


import com.ProductService.demo.productsApp.Query;
import com.ProductService.demo.productsApp.Product;
import com.ProductService.demo.productsApp.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsQuery implements Query<Void, List<Product>> {
    private final ProductRepository productRepository;

    public GetAllProductsQuery(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> execute(Void input) {

        return productRepository.findAll();
    }
}
