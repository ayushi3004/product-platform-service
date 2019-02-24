package com.Service;

import java.util.List;
import com.Bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok().body(products);
    }

    public ResponseEntity<Product> getProductsById(long id) {
        Product product =
                productRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Product with id:" + id + " not found"));
        return ResponseEntity.ok().body(product);
    }

    public ResponseEntity<Product> postProduct(Product product) {
        Product pr = productRepository.save(product);
        return ResponseEntity.ok().body(pr);
    }
}
