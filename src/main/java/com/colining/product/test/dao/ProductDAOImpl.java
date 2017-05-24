package com.colining.product.test.dao;

import com.colining.product.test.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/5/24.
 */
@Service
@Transactional
public class ProductDAOImpl implements ProductDAO {
    public static List<Product> products;
    static {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product("111","mac",555,"2"));
        list.add(new Product("222","asus",666,"3"));
        products = list;
    }

    public Product findById(String id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findProducts() {
        return products;
    }

}
