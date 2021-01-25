package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.service.IProductAmountService;
import org.springframework.stereotype.Service;

@Service
public class ProductAmountService implements IProductAmountService {
    public int getByProductId(String id) {
        return 10;
    }
}
