package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.service.IProductImageService;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService implements IProductImageService {

    @Override
    public String getProductMainImage(String productId) {
        return "https://cdn.dsmcdn.com//ty16/product/media/images/20201008/19/14253628/91657196/1/1_org.jpg";
    }
}
