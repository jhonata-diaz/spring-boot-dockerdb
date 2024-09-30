package com.ProductService.demo.productsApp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductDto {
    private final Integer id;
    private final ProductDto productDto;


}