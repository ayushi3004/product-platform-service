package com.Controller;

import com.Bean.Product;
import com.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MyController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = GET, path = "/products")
    public List<Product> getProducts(Model model) {
        return productService.getAllProducts();
    }
}
