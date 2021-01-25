package com.azaderdogan.shoppingapp.product.service;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;

import java.math.BigDecimal;

public interface IProductPriceService {
     BigDecimal getByMoneyType(String id, MoneyTypes moneyTypes);
}
