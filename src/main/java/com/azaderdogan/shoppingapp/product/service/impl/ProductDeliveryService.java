package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import com.azaderdogan.shoppingapp.product.service.IProductDeliveryService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductDeliveryService implements IProductDeliveryService {
    @Override
    public String getDeliveryInfo(String productId) {
        return "Tomorrow";
    }

    @Override
    public boolean freeDeliveryCheck(String productId, BigDecimal price, MoneyTypes moneyTypes) {
        //todo
        return true;
    }
}
