package com.colining.product.test.dao;

import com.colining.product.test.model.Product;
import com.colining.product.test.utils.JDBCUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by asus on 2017/5/24.
 */
@Service
@Transactional
public class ProductDAOImpl implements ProductDAO {


    public static ConcurrentHashMap<Long, Long> hashMap = null;
    public static List<Product> productList = null;
    public static ArrayList<Long> arrayList = new ArrayList<Long>();


    @Override
    public List<Product> findProductsByCateId(long cateId) {
        productList = new LinkedList<Product>();
        if (hashMap == null)
            hashMap = findProductCate();
        findChild(cateId);
        while (!arrayList.isEmpty()) {
            long ID = arrayList.get(0);
            findProducts(ID);
            arrayList.remove(0);
        }
        return productList;
    }

    /**
     * 寻找分级中的子层
     *
     * @param cateId
     */
    public void findChild(long cateId) {
        arrayList.add(cateId);
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            long id = (Long) entry.getKey();
            long parent = (Long) entry.getValue();
            if (cateId == parent) {
                iterator.remove();
                findChild(id);
            }
        }
        return;
    }

    /**
     * 用于寻找一个商品的类别，及父类别
     *
     * @param Id
     * @return
     */
    @Override
    public String findProductCateName(long Id) {
        if (hashMap == null)
            hashMap = findProductCate();
        System.out.println(hashMap);
        StringBuffer cate = new StringBuffer("");
        System.out.println(hashMap);
        System.out.println("当前类别" + cate.toString());
        if (hashMap == null || !hashMap.containsKey(Id))
            return "your input is wrong:)";
        while (hashMap != null && hashMap.containsKey(Id)) {
            cate.append(findCateName(Id));

            if (hashMap.get(Id) == null)
                break;
            Id = hashMap.get(Id);
            cate.append(" /");
        }
        System.out.println(cate.toString());
        return cate.toString();
    }


    //下面是附加的用于数据库操作的类：

    /**
     * 将分类表提前取出
     *
     * @return
     */
    public ConcurrentHashMap findProductCate() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cate";
        ConcurrentHashMap<Long, Long> hashMap = new ConcurrentHashMap();
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                long a = rs.getInt(1);
                long b = rs.getInt(3);
                hashMap.put(a, b);
            }
            JDBCUtils.free(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    /**
     * 取出分类的相关信息，比如说分类的名字
     *
     * @param id
     * @return
     */
    public String findCateName(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cate WHERE  cateId = " + id;
        String name = "";
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(2);
            }
            JDBCUtils.free(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 寻找类别相关的产品
     *
     * @param cateId
     */
    public void findProducts(long cateId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT  * FROM  product.products WHERE cateId =" + cateId;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getLong(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getLong(4));
                productList.add(product);
            }
            JDBCUtils.free(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
