package com.colining.product.test.controller;

import com.colining.product.test.model.Product;
import com.colining.product.test.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by asus on 2017/5/24.
 */
@RestController
public class ProductManageRestController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProduct() {
        List<Product> products = productDAO.findProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        Product product = productDAO.findById(id);
        if (product == null)
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
}
