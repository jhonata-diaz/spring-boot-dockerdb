package com.ProductService.demo.productsApp;


import com.ProductService.demo.productsApp.Command;
import com.ProductService.demo.productsApp.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductCommand implements Command<Integer, Void> {
    private final ProductRepository productRepository;

    public DeleteProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Void execute(Integer input) {
        productRepository.deleteById(input);
        return null;
    }
}
