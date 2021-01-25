package com.azaderdogan.shoppingapp.product.domain.mongo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * farklı ülkelerde  farklı fiyat ve para tipi olacağından bağımsız kıldık
 */
@Document(collection = "product_price")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProductPrice {

    private String id;
    private String productId;
    private String money;
    private String price;
}
