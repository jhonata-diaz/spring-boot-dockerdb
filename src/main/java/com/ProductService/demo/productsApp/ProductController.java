package com.ProductService.demo.productsApp;


import com.ProductService.demo.productsApp.CreateProductCommand;
import com.ProductService.demo.productsApp.DeleteProductCommand;
import com.ProductService.demo.productsApp.UpdateProductCommand;
import com.ProductService.demo.productsApp.Product;
import com.ProductService.demo.productsApp.GetAllProductsQuery;
import com.ProductService.demo.productsApp.GetProductByIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final CreateProductCommand createProductCommand;
    private final UpdateProductCommand updateProductCommand;
    private final DeleteProductCommand deleteProductCommand;
    private final GetAllProductsQuery getAllProductsQuery;
    private final GetProductByIdQuery getProductByIdQuery;

    public ProductController(CreateProductCommand createProductCommand,
                             UpdateProductCommand updateProductCommand,
                             DeleteProductCommand deleteProductCommand,
                             GetAllProductsQuery getAllProductsQuery,
                             GetProductByIdQuery getProductByIdQuery) {
        this.createProductCommand = createProductCommand;
        this.updateProductCommand = updateProductCommand;
        this.deleteProductCommand = deleteProductCommand;
        this.getAllProductsQuery = getAllProductsQuery;
        this.getProductByIdQuery = getProductByIdQuery;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(getAllProductsQuery.execute(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return getProductByIdQuery.execute(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createProductCommand.execute(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody  ProductDto productDto) {
        UpdateProductDto updateProductDto = new UpdateProductDto(id, productDto);
        return ResponseEntity.ok(updateProductCommand.execute(updateProductDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return getProductByIdQuery.execute(id)
                .map(existingProduct -> {
                    deleteProductCommand.execute(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}