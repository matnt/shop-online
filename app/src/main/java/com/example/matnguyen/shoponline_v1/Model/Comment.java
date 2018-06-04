package com.example.matnguyen.shoponline_v1.Model;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private Date CreatedDate;
    private int productId;
    private int userId;

    public Comment() {
    }

    public Comment(int id, String content, Date createdDate, int productId, int userId) {
        this.id = id;
        this.content = content;
        CreatedDate = createdDate;
        this.productId = productId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
