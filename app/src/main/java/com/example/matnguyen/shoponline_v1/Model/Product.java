package com.example.matnguyen.shoponline_v1.Model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String image;
    private int category_id;
    private int price;
    private int company_id;
    private Date created_date;
    private String description;


    public Product(){

    }

    public Product(int id, String name, String image, int category_id, int price, int company_id, Date created_date, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.category_id = category_id;
        this.price = price;
        this.company_id = company_id;
        this.created_date = created_date;
        this.description = description;

    }

    public Product(int id, String name, String image, int price, String description){
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
