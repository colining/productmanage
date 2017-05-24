package com.colining.product.test.dao;


import com.colining.product.test.model.Product;


import java.util.List;

/**
 * Created by asus on 2017/5/24.
 */
public interface ProductDAO {

    List<Product> findProductsByCateId(long cateId);

    String findProductCateName(long Id);
}
