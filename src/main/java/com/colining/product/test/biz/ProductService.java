package com.colining.product.test.biz;

import com.colining.product.test.dao.ProductDAO;
import com.colining.product.test.model.Product;
import com.colining.product.test.utils.DAOFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/5/24.
 */
@Service
public class ProductService {
    //以类别id查询相关产品
    public List<Product> findProductList(long cateId) {
        ProductDAO productDAO = (ProductDAO) DAOFactory.newInstance("productDAO");
        return productDAO.findProductsByCateId(cateId);
    }

    //以类别id来查询从属类别（它的父类别）
    public String findProductCateName(long Id) {
        ProductDAO productDAO = (ProductDAO) DAOFactory.newInstance("productDAO");
        return productDAO.findProductCateName(Id);
    }

}
