package com.azaderdogan.shoppingapp.product.repository.es;

import com.azaderdogan.shoppingapp.product.domain.es.CategoryEs;
import com.azaderdogan.shoppingapp.product.domain.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

/**
 * category ve company nesnelerini product üzerinden seralize edeceğiz.
 * Tümü tek index üzeinde olacak
 */
public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs,String> {

    Flux<ProductEs> getProductEsByCategory_Id(String categoryId);
}
