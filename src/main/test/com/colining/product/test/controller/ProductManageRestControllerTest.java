package com.colining.product.test.controller;

import com.colining.product.test.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/5/24.
 */
public class ProductManageRestControllerTest {
    public static final String REST_SERVICE_URI = "http://localhost:7777";
    @org.junit.Test
    public void getProductCateName() throws Exception {
        System.out.println("Testing getProductCateName API----------");
        RestTemplate restTemplate = new RestTemplate();
        //商品类别为5的商品的类别从属；
        String s = restTemplate.getForObject(REST_SERVICE_URI+"/product/5", String.class);
        assertTrue(s.equals("Computer /Electronic /entity /"));
        String s1 = restTemplate.getForObject(REST_SERVICE_URI+"/product/10000", String.class);
        assertTrue(s1.equals("your input is wrong:)"));
    }

    @org.junit.Test
    public void findProductsByCateId() throws Exception {
        System.out.println("Testing findProductsByCateId API-----------");

        RestTemplate restTemplate = new RestTemplate();
        //类型6的仅有小米电视，类型7的仅有MacBook。其他会提示并没有商品存在；
        List<LinkedHashMap<String, Object>> productMap = restTemplate.getForObject(REST_SERVICE_URI+"/products/6", List.class);
        if(productMap!=null){
            for(LinkedHashMap<String, Object> map : productMap){
                System.out.println("product : productId="+map.get("productId")+", productName="+map.get("productName")+", Price="+map.get("productPrice")+", cateId="+map.get("cateId"));
            }
        }else{
            System.out.println("No product exist----------");
        }
    }

}