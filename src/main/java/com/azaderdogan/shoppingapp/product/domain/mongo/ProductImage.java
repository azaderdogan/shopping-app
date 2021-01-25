package com.azaderdogan.shoppingapp.product.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * kendi idsi olmayacak field olarak saklaycağız
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    private ImageType imageType;
    private String url;

    public enum ImageType{
        FEATURE, NORMAL
    }
}
