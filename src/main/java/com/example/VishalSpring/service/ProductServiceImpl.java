package com.example.VishalSpring.service;

import com.example.VishalSpring.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl {
    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    DataSource data;

    public static List<Product> p=new ArrayList<>();
    static{

        p.add(new Product(1,1,"11","ddas","asdad",new BigDecimal(100)));
        p.add(new Product(2,2,"22","ddas","asdad",new BigDecimal(100)));
    }

    @Autowired
    public void setProductRepository() {
    }

    public List<Product> listAllProducts() {
        logger.debug("listAllProducts called");
        return p;
    }

    public Product getProductById(Integer id) {
        logger.debug("getProductById called");
        return p.get(id);
    }

    @Transactional(isolation=Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Product saveProduct(Product product) {
        logger.debug("saveProduct called");
        p.add(product);
        return product;
    }

    public void deleteProduct(Integer id) {
        logger.debug("deleteProduct called");
        p.remove(id);
       }
}
