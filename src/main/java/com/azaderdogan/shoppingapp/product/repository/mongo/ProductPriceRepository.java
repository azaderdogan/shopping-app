package com.azaderdogan.shoppingapp.product.repository.mongo;

import com.azaderdogan.shoppingapp.product.domain.mongo.ProductPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductPriceRepository extends ReactiveMongoRepository<ProductPrice, String> {

}
