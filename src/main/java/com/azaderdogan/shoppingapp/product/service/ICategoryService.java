package com.azaderdogan.shoppingapp.product.service;

import com.azaderdogan.shoppingapp.product.domain.mongo.category.Category;
import com.azaderdogan.shoppingapp.product.model.category.CategoryResponse;
import com.azaderdogan.shoppingapp.product.model.category.CategorySaveRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ICategoryService {
    Flux<CategoryResponse> getAllCategories();

    Category getById(String id);

    CategoryResponse saveCategory(CategorySaveRequest request);

}
