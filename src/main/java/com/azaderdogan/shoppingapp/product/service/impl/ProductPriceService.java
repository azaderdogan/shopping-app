package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import com.azaderdogan.shoppingapp.product.repository.mongo.ProductPriceRepository;
import com.azaderdogan.shoppingapp.product.service.IProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService implements IProductPriceService {

    private final ProductPriceRepository productPriceRepository;
    @Override
    public BigDecimal getByMoneyType(String id, MoneyTypes moneyTypes) {
        //todo
        return BigDecimal.TEN;
    }
}
