package com.azaderdogan.shoppingapp.product.startup;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import com.azaderdogan.shoppingapp.product.model.ProductSaveRequest;
import com.azaderdogan.shoppingapp.product.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.UUID.*;

@Component
@RequiredArgsConstructor
public class ProductBootstrap {
    private final ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {
            IntStream.range(0, 20).forEach(item -> {
                productService.save(ProductSaveRequest.builder()
                        .sellerId(randomUUID().toString())
                        .id(randomUUID().toString())
                        .description("Product Description" + item)
                        .money(MoneyTypes.USD)
                        .price(BigDecimal.valueOf(2500))
                        .categoryId(randomUUID().toString())
                        .name("Product name" + item)
                        .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                        .images(Arrays.asList("https://cdn.dsmcdn.com//ty16/product/media/images/20201008/19/14253628/91657196/1/1_org.jpg", "https://cdn.dsmcdn.com/ty25/product/media/images/20201124/22/31552537/111694429/1/1_org_zoom.jpg"))
                        .build());
            });
        }
    }


}
