package com.azaderdogan.shoppingapp.product.service;

import com.azaderdogan.shoppingapp.product.domain.es.ProductEs;
import com.azaderdogan.shoppingapp.product.domain.mongo.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductEsService {

   Mono<ProductEs> saveNewProduct(Product product);

   Flux<ProductEs> findAll();
   Flux<ProductEs> getProductsByCategoryId(String categoryId);

}
