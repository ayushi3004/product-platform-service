package com.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The auto-generated version of product")
    @Column(name = "productId", nullable = false)
    private long productId;

    @ApiModelProperty(notes = "Product name")
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(notes = "Product price")
    @Column(name = "price", nullable = false)
    private int price;

    @ApiModelProperty(notes = "Product category path")
    @Column(name = "breadcrumbs", nullable = false)
    private String breadcrumbs;

    @ApiModelProperty(notes = "Product store")
    @Column(name = "storeName", nullable = false)
    private String storeName;

    @ApiModelProperty(notes = "Comments on product")
    @OneToMany(fetch = FetchType.EAGER, mappedBy="product",cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(String breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
