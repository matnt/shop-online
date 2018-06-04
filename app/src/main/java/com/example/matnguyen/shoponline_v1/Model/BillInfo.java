package com.example.matnguyen.shoponline_v1.Model;

public class BillInfo {
    private int id;
    private int productId;
    private int quantity;
    private int sumPrice;

    public BillInfo(int id, int productId, int quantity, int sumPrice) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.sumPrice = sumPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
}
