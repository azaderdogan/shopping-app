package com.azaderdogan.shoppingapp.product.domain.mongo.category;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Data
@Builder
public class Category {

    @Id
    private String id;
    private String name;
    private String  code;
}
