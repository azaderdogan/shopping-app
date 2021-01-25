package com.azaderdogan.shoppingapp.product.repository.mongo;

import com.azaderdogan.shoppingapp.product.domain.mongo.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Asenkron arama yapmamızı sağlayan reactivedir
 */
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

}
