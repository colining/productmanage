package com.colining.product.test.configuration;

/**
 * Created by asus on 2017/5/24.
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.colining.product.test")
public class  ProductManageConfiguration{


}