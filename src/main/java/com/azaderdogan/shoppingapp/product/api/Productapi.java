package com.azaderdogan.shoppingapp.product.api;

import com.azaderdogan.shoppingapp.product.model.product.ProductResponse;
import com.azaderdogan.shoppingapp.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class Productapi {
    private final IProductService productService;

    @GetMapping
    public Flux<ProductResponse> getAllProducts(){
        return productService.getAll();
    }
    @GetMapping("/category/{categoryId}")
    public Flux<ProductResponse> getProductsByCategoryId(@PathVariable("categoryId") String categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }
}
