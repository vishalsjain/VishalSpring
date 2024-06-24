package com.example.VishalSpring.service;

import com.example.VishalSpring.dao.service.ProductDaoImpl;
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

    public void setData(ProductDaoImpl data) {
        this.data = data;
    }
    @Autowired
    ProductDaoImpl data;
    public List<Product> listAllProducts() {
        logger.debug("listAllProducts called");
        return data.listAllProducts();
    }

    public Product getProductById(Integer id) {
        logger.debug("getProductById called");
        Product p=data.getProductById(id);
        if (p == null) {
            throw new RuntimeException("Vishal Exception");
}
        return p;
    }

    @Transactional(isolation=Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Product saveProduct(Product product) {
        logger.debug("saveProduct called");
        return data.saveProduct(product);
    }

    public void deleteProduct(Integer id) throws  RuntimeException{
        logger.debug("deleteProduct called");
      try {
          data.deleteProduct(id);
      }
      catch(RuntimeException e){
          throw new RuntimeException();
      }

      }
}
