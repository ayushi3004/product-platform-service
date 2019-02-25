package com.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    @ApiModelProperty(notes = "The auto-generated version of comment")
    private int commentId;

    @ApiModelProperty(notes = "User name of comment poster")
    @Column(name = "userName", nullable = false)
    private String userName;

    @ApiModelProperty(notes = "Comment")
    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private Product product;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
