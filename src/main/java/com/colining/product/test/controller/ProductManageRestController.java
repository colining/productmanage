package com.colining.product.test.controller;

import com.colining.product.test.biz.ProductService;
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
    ProductService productService;

    //通过类别id获取产品的分类路径
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProductCateName(@PathVariable("id") long id) {
        String cateName = productService.findProductCateName(id);
        if (cateName == null)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<String>(cateName, HttpStatus.OK);
    }

    //通过类别id来获取产品
    @RequestMapping(value = "/products/{cateid}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findProductsByCateId(@PathVariable("cateid") long id) {
        List<Product> products = productService.findProductList(id);
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
