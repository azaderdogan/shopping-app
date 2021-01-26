package com.azaderdogan.shoppingapp.product.service;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;

import java.math.BigDecimal;

public interface IProductDeliveryService {

    String getDeliveryInfo(String productId);

    boolean freeDeliveryCheck(String productId, BigDecimal price, MoneyTypes moneyTypes);
}
