package com.controller;

import com.models.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = GET, path = "/products")
    public ResponseEntity<List<Product>> getProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(method = GET, path = "/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable(value = "id") Long id) {
        return productService.getProductsById(id);
    }

    @RequestMapping(method = POST, path = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        return productService.postProduct(product);
    }
}
