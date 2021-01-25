package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.domain.es.CategoryEs;
import com.azaderdogan.shoppingapp.product.domain.es.CompanyEs;
import com.azaderdogan.shoppingapp.product.domain.es.ProductEs;
import com.azaderdogan.shoppingapp.product.domain.mongo.Product;
import com.azaderdogan.shoppingapp.product.repository.es.ProductEsRepository;
import com.azaderdogan.shoppingapp.product.service.IProductEsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductEsService implements IProductEsService {
    private final ProductEsRepository productEsRepository;

    @Override
    public Mono<ProductEs> saveNewProduct(Product product) {

    return   productEsRepository.save(ProductEs.builder()
                .active(product.getActive())
                .code(product.getCode())
                .description(product.getDescription())
                .features(product.getFeatures())
                .id(product.getId())
                .name(product.getName())
                //todo
                .seller(CompanyEs.builder().id(product.getCompanyId()).name("Test").build())
              //todo
                .category(CategoryEs.builder().id(product.getCategoryId()).name("Test").build())
                .build());

    }

    @Override
    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }
}
