package com.azaderdogan.shoppingapp.product.service;

import java.math.BigDecimal;

public interface IProductDeliveryService {

    String getDeliveryInfo(String productId);

    boolean freeDeliveryCheck(String productId, BigDecimal price);
}
