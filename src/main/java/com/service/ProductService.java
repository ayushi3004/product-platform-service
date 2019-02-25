package com.service;

import java.util.List;
import com.models.Comment;
import com.models.Product;
import com.repository.ProductRepository;
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

    public ResponseEntity<List<Comment>> getCommentsByPid(long id) {
        Product product =
                productRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Product with id:" + id + " not found"));
        return ResponseEntity.ok().body(product.getComments());
    }

    public ResponseEntity<Comment> getCommentsByCid(long pid, long cid) throws Exception{
        Product product =
                productRepository
                        .findById(pid)
                        .orElseThrow(() -> new ResourceNotFoundException("Product with id:" + pid + " not found"));

        Comment comment;
        try {
            comment = product.getComments().get((int)cid-1);
        }catch (Exception e){
            throw new Exception("Comment with id:"+ cid +" not found");
        }
        return ResponseEntity.ok().body(comment);
    }
}
