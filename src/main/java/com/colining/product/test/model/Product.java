package com.colining.product.test.model;

/**
 * Created by asus on 2017/5/24.
 */
public class Product {
    private String productId;
    private String productName;
    private int productPrice;
    private String cateId;

    public Product(String productId, String productName, int productPrice, String cateId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.cateId = cateId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", cateId='" + cateId + '\'' +
                '}';
    }
}
