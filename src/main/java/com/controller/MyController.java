package com.controller;

import com.models.Comment;
import com.models.Product;
import com.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(
    value = "Product platform service",
    description = "Operations related to products and comments on them")
@RestController
public class MyController {

  @Autowired ProductService productService;

  @ApiOperation(value = "View list of products", response = List.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved product list"),
        @ApiResponse(code = 500, message = "Error")
      })
  @RequestMapping(method = GET, path = "/products")
  public ResponseEntity<List<Product>> getProducts() {
    return productService.getAllProducts();
  }

  @ApiOperation(value = "Get product with {id}")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved product"),
        @ApiResponse(code = 500, message = "Error")
      })
  @RequestMapping(method = GET, path = "/products/{id}")
  public ResponseEntity<Product> getProductsById(@PathVariable(value = "id") Long id) {
    return productService.getProductsById(id);
  }

  @ApiOperation(value = "Add a new product")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully posted"),
        @ApiResponse(code = 500, message = "Error")
      })
  @RequestMapping(method = POST, path = "/products")
  public ResponseEntity<Product> postProduct(@RequestBody Product product) {
    return productService.postProduct(product);
  }

  @ApiOperation(value = "View list of comments for a product with {id}", response = List.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list of comments"),
        @ApiResponse(code = 500, message = "Error")
      })
  @RequestMapping(method = GET, path = "/products/{id}/comments")
  public ResponseEntity<List<Comment>> getCommentsByPid(@PathVariable(value = "id") Long id) {
    return productService.getCommentsByPid(id);
  }

  @ApiOperation(value = "View comment {cid} of product with {pid}")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved comment"),
        @ApiResponse(code = 500, message = "Error")
      })
  @RequestMapping(method = GET, path = "/products/{pid}/comments/{cid}")
  public ResponseEntity<Comment> getCommentsByPid(
      @PathVariable(value = "pid") Long pid, @PathVariable(value = "cid") Long cid)
      throws Exception {
    return productService.getCommentsByCid(pid, cid);
  }

  @ApiOperation(value = "Add comments to a product with {id}", response = List.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully posted comment"),
        @ApiResponse(code = 500, message = "Error")
      })
  @RequestMapping(method = POST, path = "/products/{pid}/comments")
  public ResponseEntity<Product> postComments(
      @PathVariable(value = "pid") Long id, @RequestBody Comment comment) {
    return productService.postComments(id, comment);
  }
}
