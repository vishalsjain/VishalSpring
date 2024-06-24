package com.example.VishalSpring;

import com.example.VishalSpring.dao.service.ProductDaoImpl;
import com.example.VishalSpring.model.Product;
import com.example.VishalSpring.service.ProductServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import  org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    //@Mock will create mock object but it will not call actual object, henc eif you need to call actual service
    //then use @spy
    @Mock
    ProductServiceImpl ps;

    //@Spy
    @InjectMocks
    ProductServiceImpl spyPs;

    @InjectMocks
    ProductDaoImpl pdao;

    @Mock
    ProductDaoImpl data;

    @Test
    public void spyGetProductById(){
when(data.getProductById(1)).thenReturn(getProductData());
        Product p=spyPs.getProductById(1);
        System.out.println(p);

    }


    @Test
    public void mockgetProductById(){

        when(ps.getProductById(1)).thenReturn(getProductData());

        System.out.println(ps.getProductById(1).toString());
            assertEquals("123",ps.getProductById(1).getDescription());

            //this is JUNIT5
assertAll("testdata",
        ()->assertEquals("123",ps.getProductById(1).getDescription())
,
        ()->assertEquals("11",ps.getProductById(1).getProductId()));

    }




    public Product  getProductData(){
        System.out.println("getProductData called of JUNIt class");
Product p=new Product(1,1,"11","ddas","asdad",new BigDecimal(100));
p.setDescription("123");
       return p;
    }

}
