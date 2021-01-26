package com.azaderdogan.shoppingapp.product.model.product;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductResponse {


    private String id;
    private String name;
    private String image;
    private String description;
    //sellerin id ve ismine ihtiyaç duyacağımız için nesne olarak tutuyoruz
    private ProductSellerResponse seller;
    private String features;
    private int available;
    private boolean freeDelivery;
    private String deliveryIn;
    private String moneySymbol;
    private BigDecimal price;
    private String categoryId;
}
