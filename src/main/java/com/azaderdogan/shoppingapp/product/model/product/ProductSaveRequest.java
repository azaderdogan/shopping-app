package com.azaderdogan.shoppingapp.product.model.product;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class ProductSaveRequest {

    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available; // küsüratlı bir ütün vey metre bazında ürün satışı olabileiceinden
    private HashMap<MoneyTypes, BigDecimal> price;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}
/**
 * kalıcı olarak mongodb availeble bilgisi redisten gelecek
 * { document - ES mongoda tutalcak ES aranacak
 * 'id'
 * 'image': 'https://cdn.dsmcdn.com//ty16/product/media/images/20201008/19/14253628/91657196/1/1_org.jpg', sub - document
 * 'name':
 * 'description':
 * 'seller': - document - ES
 * 'features':  -html document - ES
 * 'available': 2, -redis and document
 * 'freeDelivery': true, - service / if price>50
 * 'deliveryIn': 'In 3 days', - calc util
 * 'price': 120,
 * 'category' - document
 * 'money': '$' - enum()
 * },
 **/
