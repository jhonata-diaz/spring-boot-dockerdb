package com.ProductService.demo.productsApp;


import ch.qos.logback.core.util.StringUtil;
import com.ProductService.demo.productsApp.Command;
import com.ProductService.demo.productsApp.ErrorHandle.ProductBadRequestException;
import com.ProductService.demo.productsApp.Product;
import com.ProductService.demo.productsApp.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CreateProductCommand implements Command<ProductDto, Product> {
    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(ProductDto input) {
        ProductDto data = input;
        if (StringUtils.isEmpty(data.getName())) {
           // throw new ProductBadRequestException("name is required");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product name is required");
        }

        Product product = new Product();
        product.setName(data.getName());
        product.setDescription(data.getDescription());
        return productRepository.save(product);
    }

}