package com.Controller;

import com.Bean.Product;
import com.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
}
