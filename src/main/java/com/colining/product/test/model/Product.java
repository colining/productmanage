package com.colining.product.test.model;

/**
 * Created by asus on 2017/5/24.
 */
public class Product {
    private long productId;
    private String productName;
    private long productPrice;
    private long cateId;

    public Product(long productId, String productName, long productPrice, long cateId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.cateId = cateId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public long getCateId() {
        return cateId;
    }

    public void setCateId(long cateId) {
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
