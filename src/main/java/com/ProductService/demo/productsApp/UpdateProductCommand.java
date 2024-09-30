package com.ProductService.demo.productsApp;

import com.ProductService.demo.productsApp.Command;
import com.ProductService.demo.productsApp.Product;
import com.ProductService.demo.productsApp.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductCommand implements Command<UpdateProductDto, Product> {
    private final ProductRepository productRepository;

    public UpdateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(UpdateProductDto  input) {
        Product existingProduct = productRepository.findById(input.getId()).orElseThrow();
        existingProduct.setName(input.getProductDto().getName());
        existingProduct.setDescription(input.getProductDto().getDescription());
        return productRepository.save(existingProduct);
    }
}
