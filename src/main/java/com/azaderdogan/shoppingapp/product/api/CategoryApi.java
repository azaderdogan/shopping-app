package com.azaderdogan.shoppingapp.product.api;

import com.azaderdogan.shoppingapp.product.model.category.CategoryResponse;
import com.azaderdogan.shoppingapp.product.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryApi {

    private final ICategoryService categoryService;

    @GetMapping
    public Flux<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Flux<CategoryResponse> getById(@PathVariable("id") String id) {
        return categoryService.getAllCategories();
    }

}
