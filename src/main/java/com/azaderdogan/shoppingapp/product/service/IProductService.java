package com.azaderdogan.shoppingapp.product.service;


import com.azaderdogan.shoppingapp.product.domain.es.ProductEs;
import com.azaderdogan.shoppingapp.product.model.product.ProductResponse;
import com.azaderdogan.shoppingapp.product.model.product.ProductSaveRequest;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getByPaging(Pageable pageable);

    Flux<ProductResponse> getAll();

    ProductResponse save(ProductSaveRequest productSaveRequest);

    Flux<ProductResponse> getProductsByCategoryId(String categoryId);

    Mono<Long> count();
}
