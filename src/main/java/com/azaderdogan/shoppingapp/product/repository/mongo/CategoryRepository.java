package com.azaderdogan.shoppingapp.product.repository.mongo;

import com.azaderdogan.shoppingapp.product.domain.mongo.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {
}
