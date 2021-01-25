package com.azaderdogan.shoppingapp.product.repository.es;

import com.azaderdogan.shoppingapp.product.domain.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

/**
 * category ve company nesnelerini product üzerinden seralize edeceğiz.
 * Tümü tek index üzeinde olacak
 */
public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs,String> {
}
