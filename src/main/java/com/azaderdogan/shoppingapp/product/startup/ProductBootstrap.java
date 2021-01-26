package com.azaderdogan.shoppingapp.product.startup;

import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import com.azaderdogan.shoppingapp.product.model.category.CategoryResponse;
import com.azaderdogan.shoppingapp.product.model.category.CategorySaveRequest;
import com.azaderdogan.shoppingapp.product.model.product.ProductSaveRequest;
import com.azaderdogan.shoppingapp.product.repository.es.ProductEsRepository;
import com.azaderdogan.shoppingapp.product.service.impl.CategoryService;
import com.azaderdogan.shoppingapp.product.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

import static java.util.UUID.*;

@Component
@RequiredArgsConstructor
public class ProductBootstrap {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductEsRepository productEsRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {

        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {
            //eklenecekse temizlensin
            productEsRepository.deleteAll();

            CategoryResponse elektrik = categoryService.saveCategory(CategorySaveRequest.builder().name("Elektronik").build());
            CategoryResponse bilgisayar = categoryService.saveCategory(CategorySaveRequest.builder().name("Bilgisayar").build());
            CategoryResponse telefon = categoryService.saveCategory(CategorySaveRequest.builder().name("Telefon").build());
            CategoryResponse kırtasiye = categoryService.saveCategory(CategorySaveRequest.builder().name("Kırtasiye").build());
            CategoryResponse yemek = categoryService.saveCategory(CategorySaveRequest.builder().name("Yemek").build());

            IntStream.range(0, 10).forEach(item -> {
                HashMap<MoneyTypes, BigDecimal> price = new HashMap<>() {
                    {
                        put(MoneyTypes.USD, BigDecimal.valueOf((item + 1) * 20));
                        put(MoneyTypes.EUR, BigDecimal.valueOf((item + 1) * 15));
                    }
                };
                productService.save(ProductSaveRequest.builder()
                        .sellerId(randomUUID().toString())
                        .id(randomUUID().toString())
                        .description("Product Description" + item)
                        .price(price)
                        .categoryId(telefon.getId())
                        .name("Product name" + item)
                        .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                        .images(Arrays.asList("https://cdn.dsmcdn.com//ty16/product/media/images/20201008/19/14253628/91657196/1/1_org.jpg", "https://cdn.dsmcdn.com/ty25/product/media/images/20201124/22/31552537/111694429/1/1_org_zoom.jpg"))
                        .build());
            });
            IntStream.range(0, 10).forEach(item -> {
                HashMap<MoneyTypes, BigDecimal> price = new HashMap<>() {
                    {
                        put(MoneyTypes.USD, BigDecimal.valueOf((item + 1) * 20));
                        put(MoneyTypes.EUR, BigDecimal.valueOf((item + 1) * 15));
                    }
                };
                productService.save(ProductSaveRequest.builder()
                        .sellerId(randomUUID().toString())
                        .id(randomUUID().toString())
                        .description("Product Description" + item)
                        .price(price)
                        .categoryId(bilgisayar.getId())
                        .name("Product name" + item)
                        .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                        .images(Arrays.asList("https://cdn.dsmcdn.com//ty16/product/media/images/20201008/19/14253628/91657196/1/1_org.jpg", "https://cdn.dsmcdn.com/ty25/product/media/images/20201124/22/31552537/111694429/1/1_org_zoom.jpg"))
                        .build());
            });
        }
    }


}
