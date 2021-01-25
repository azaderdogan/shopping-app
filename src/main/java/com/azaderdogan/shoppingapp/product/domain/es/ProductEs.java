package com.azaderdogan.shoppingapp.product.domain.es;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Category ve Company fieldlerini duplicate ediyoruz.
 * Çünkü ben ES üzerinden search işlemi yaparken firma adıyla da arama yapma imkanı sunuyorum.
 * yoksa id verseydim önce id ye göre getirip daha sonra arama yaptıracaktı. (F/P)
 */
@Document(indexName = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class ProductEs {
    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String features;
    private CategoryEs category;
    private Boolean active;
}
