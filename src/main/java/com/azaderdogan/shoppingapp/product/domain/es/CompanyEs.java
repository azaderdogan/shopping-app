package com.azaderdogan.shoppingapp.product.domain.es;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class CompanyEs {
    @Id
    private String id;
    private String name;
    private String code;
}
