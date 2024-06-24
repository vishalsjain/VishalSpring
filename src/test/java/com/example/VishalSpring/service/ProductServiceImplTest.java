package com.example.VishalSpring.service;

import com.example.VishalSpring.dao.service.ProductDaoImpl;
import com.example.VishalSpring.model.Product;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * In summary, thenThrow is used when we want to throw an exception from a method that returns a value,
 * and doThrow is used when we want to throw an exception from a method that returns void.
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class ProductServiceImplTest {

@InjectMocks
ProductServiceImpl ps;

@Mock
    ProductDaoImpl data;

    @Test
    void listAllProducts() {

        when(data.listAllProducts()).thenReturn(getListOfProduct());
       assertAll("getList",
               ()-> assertEquals(  ps.listAllProducts().get(0).getProductId(),"11")
               ,()-> assertEquals(  ps.listAllProducts().get(1).getProductId(),"12")
       );
    }


    @Test
    void getProducts1() {
        when(data.getProductById(1)).thenReturn(getProductData());
        assertAll("getList",
                ()-> assertEquals(  ps.getProductById(1).getProductId(),"11")

        );
    }
    @Test
    void getProductsIfcondition() {
        when(data.getProductById(1)).thenReturn(null);
        assertAll("getList",
                ()-> assertThrows(RuntimeException.class,()->ps.getProductById(1))

        );
    }

    @Test
    void getProductById() {
    }

    @Test
    void saveProduct() {

        Product p1=new Product(1,1,"11","ddas","asdad",new BigDecimal(100));
        p1.setDescription("123");

        //very imp here while mocking you should use p1 instead of calling getProductDatat()
        when(data.saveProduct(p1)).thenReturn(getProductData1());
        // when(data.saveProduct(p1)).thenReturn(getProductData1());
        assertAll("save",
                ()-> assertEquals
                        (  ps.saveProduct(p1).getProductId(),"11"));

    }

    @Test
    void saveProduct1() {

        Product p1=new Product(1,1,"11","ddas","asdad",new BigDecimal(100));
        p1.setDescription("123");

        when(data.saveProduct(p1)).thenReturn(getProductData1());
//here since same object is not used for mock and when save method is called we get error
     /*   assertAll("save",
                ()-> assertEquals
                        (  ps.saveProduct(new Product(1,1,"11","ddas","asdad",new BigDecimal(100))).getProductId(),"11"));
  */

    }



    @Test
    void deleteProduct() {
        ps.deleteProduct(1);
      //this can be used in case of Void also can be used if you want to check if the mocked
        // method is called or not.
       //if you comment ps.deleteproductthat it will fail
        verify(data,times(1)).deleteProduct(1);

    }

    @Mock
    ProductServiceImpl psmock;

    //mocking void method with thow exception
    @Test
    void deleteProductThrowException() {

        //very imp is psmock is mockobject not inject obnect
        doThrow(RuntimeException.class)
                .when(data).deleteProduct(anyInt());
       // when(psmock.deleteProduct(1)).
       //  thenThrow(RuntimeException.class);
       //this above line will give compile time error becuase of void

       assertAll("Verigydeletethorw",
               ()->assertThrows(
                       RuntimeException.class,()->
                        //       psmock.deleteProduct(1)
                       ps.deleteProduct(1)
               ));
    }





    private ProductServiceImpl productManager;

    @Mock
    private ProductDaoImpl dataMock;

    @BeforeEach
    public void setUp() {
        productManager = new ProductServiceImpl();
      //  productManager.setData(dataMock);
    }

        @Test()
        public void testDeleteProductWithInvalidId() {
            Integer invalidId = -1;
            doThrow(new RuntimeException()).when(dataMock).deleteProduct(invalidId);

            assertThrows(RuntimeException.class,
                    () -> productManager.deleteProduct(invalidId));

        }

    @Test
    public void spyObject(){

        ArrayList al= spy(ArrayList.class);
    when(al.add("1")).thenReturn(true);
    al.add("1");
        System.out.println("Print");
       // doReturn(20).when(al).size();//since actual object is called we need to preder doreturn call
when(al.size()).thenReturn(20);
        System.out.println(al.size());
    }

























    private List<Product> getListOfProduct() {
        System.out.println("getListOfProduct called from JUNI class");

        List l=new ArrayList();
            Product p=new Product(1,1,"11","ddas","asdad",new BigDecimal(100));
            p.setDescription("123");
            l.add(p);
        p=new Product(2,1,"12","ddas","asdad",new BigDecimal(100));
          l.add(p);
            return l;
    }
    public Product  getProductData(){
        Product p=new Product(1,1,"11","ddas","asdad",new BigDecimal(100));
        p.setDescription("123");
        return p;
    }
    public Product  getProductData1(){
        Product p=new Product(1,1,"11","ddas","asdad",new BigDecimal(100));
        p.setDescription("123");
        return p;
    }


}