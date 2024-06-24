package com.example.VishalSpring.model;

import java.math.BigDecimal;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
@ApiModel(description = "Productmodel by vishal")
public class Product {

    public Product(){

    }
    public Product(Integer id, Integer version, String productId, String description, String imageUrl, BigDecimal price) {
        this.id = id;
        this.version = version;
        this.productId = productId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
    
    @ApiModelProperty(notes = "The auto-generated version of the product")
    private Integer version;
    
    @ApiModelProperty(notes = "The application-specific product ID")
    private String productId;
    
    @ApiModelProperty(notes = "The product description")
    private String description;
    
    @ApiModelProperty(notes = "The image URL of the product")
    private String imageUrl;
    
    @ApiModelProperty(notes = "The price of the product", required = true)
    private BigDecimal price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", version=" + version +
                ", productId='" + productId + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
