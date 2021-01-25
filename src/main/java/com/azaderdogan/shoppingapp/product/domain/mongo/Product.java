package com.azaderdogan.shoppingapp.product.domain.mongo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Data
@Builder
public class Product {

    private String id;
    private String name;
    private String code;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private List<ProductImage> productImages;
    private Boolean active;

}

/**
 * kalıcı olarak mongodb availeble bilgisi redisten gelecek
 *   { document - ES mongoda tutalcak ES aranacak
 *       'id'
 *       'image': 'https://cdn.dsmcdn.com//ty16/product/media/images/20201008/19/14253628/91657196/1/1_org.jpg', sub - document
 *       'name':
 *       'description':
 *       'seller': - document - ES
 *       'features':  -html document - ES
 *       'available': 2, -redis and document
 *       'freeDelivery': true, - service / if price>50
 *       'deliveryIn': 'In 3 days', - calc util
 *       'price': 120,
 *       'category' - document
 *       'money': '$' - enum()
 *     },
 **/
