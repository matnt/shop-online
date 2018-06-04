package com.example.matnguyen.shoponline_v1.Model;

import java.util.Date;

public class Bill {
    private int id;
    private int user_id;
    private Date created_date;
    private int total_price;
    private String address;
    private int phone_number;

    public Bill(int id, int user_id, Date created_date, int total_price, String address, int phone_number) {
        this.id = id;
        this.user_id = user_id;
        this.created_date = created_date;
        this.total_price = total_price;
        this.address = address;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
