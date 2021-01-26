package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.domain.mongo.category.Category;
import com.azaderdogan.shoppingapp.product.model.category.CategoryResponse;
import com.azaderdogan.shoppingapp.product.model.category.CategorySaveRequest;
import com.azaderdogan.shoppingapp.product.repository.mongo.CategoryRepository;
import com.azaderdogan.shoppingapp.product.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Flux<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().map(this::mapToDto);
    }

    @Override
    public Category getById(String id) {
        return categoryRepository.findById(id).block();
    }

    @Override
    public CategoryResponse saveCategory(CategorySaveRequest request) {
        Category category = Category.builder().name(request.getName()).code("C" + request.getName().charAt(0)).build();
        return mapToDto(categoryRepository.save(category).block());


    }

    private CategoryResponse mapToDto(Category category) {
        if (category == null)
            return null;
        return CategoryResponse.builder().id(category.getId()).name(category.getName()).code(category.getCode()).build();
    }
}
