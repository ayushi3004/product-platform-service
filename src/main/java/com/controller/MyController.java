package com.controller;

import com.models.Comment;
import com.models.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        return productService.postProduct(product);
    }

    @RequestMapping(method = GET, path = "/products/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentsById(@PathVariable(value = "id") Long id) {
        return productService.getCommentsById(id);
    }
}
