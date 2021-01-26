package com.azaderdogan.shoppingapp.product.service.impl;

import com.azaderdogan.shoppingapp.product.domain.es.ProductEs;
import com.azaderdogan.shoppingapp.product.domain.mongo.MoneyTypes;
import com.azaderdogan.shoppingapp.product.domain.mongo.Product;
import com.azaderdogan.shoppingapp.product.domain.mongo.ProductImage;
import com.azaderdogan.shoppingapp.product.model.product.ProductResponse;
import com.azaderdogan.shoppingapp.product.model.product.ProductSaveRequest;
import com.azaderdogan.shoppingapp.product.model.product.ProductSellerResponse;
import com.azaderdogan.shoppingapp.product.repository.mongo.ProductRepository;
import com.azaderdogan.shoppingapp.product.service.IProductEsService;
import com.azaderdogan.shoppingapp.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

import static com.azaderdogan.shoppingapp.product.domain.mongo.ProductImage.*;
import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductEsService productEsService;
    private final ProductRepository productRepository;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;

    @Override
    public Flux<ProductResponse> getAll() {
        //1 - ES den sorgula
        return productEsService.findAll().map(this::mapToDto);
        //2 - Calc fieldleri işle
        //3 - Redisten ihtiyaç alanları getir
        //4 - Response nesnesine dönüştür.

    }

    @Override
    public Flux<ProductResponse> getProductsByCategoryId(String categoryId) {
        return productEsService.getProductsByCategoryId(categoryId).map(this::mapToDto);
    }

    /**
     * 1 - Mongoya yaz
     * 2 - Es güncelle
     * 3 - Redisten güncelle
     * 4- es den cevap dön
     * 5 - Response nesnesine dönüştür.
     *
     * @param request
     * @return
     */
    @Override
    public ProductResponse save(ProductSaveRequest request) {
        //1 - Mongoya yaz
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR0001")
                .categoryId(request.getCategoryId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .price(request.getPrice())
                .productImages(request.getImages().stream().map(item -> new ProductImage(ImageType.FEATURE, item)).collect(toList()))
                .build();
        product = productRepository.save(product).block();

        //2 - Es güncelle

        //3 - Redisten güncelle


        return  this.mapToDto(productEsService.saveNewProduct(product).block());
    }

    @Override
    public Mono<Long> count() {
        //çağırılan yerde handler edeeceğiz. asenkronluğu bozmamak adına
        return productRepository.count();
    }

    @Override
    public List<ProductResponse> getByPaging(Pageable pageable) {
        //1 - ES den sorgula

        //2 - Calc fieldleri işle
        //3 - Redisten ihtiyaç alanları getir
        //4 - Response nesnesine dönüştür.
        return null;
    }

    /**
     * 2 - Calc fieldleri işle
     * 3 - Redisten ihtiyaç alanları getir
     * 4 - Response nesnesine dönüştür.
     *
     * @param productEs
     * @return
     */
    private ProductResponse mapToDto(ProductEs productEs) {
        if (productEs == null){
            return null;
        }
        return ProductResponse.builder()
                //todo client request üzerinden validate edifice
                .price(productEs.getPrice().get("USD"))
                .moneySymbol(MoneyTypes.USD.getSymbol())
                .features(productEs.getFeatures())
                .id(productEs.getId())
                .description(productEs.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(productEs.getId()))
                .categoryId(productEs.getCategory().getId())
                .available(productAmountService.getByProductId(productEs.getId()))
                .name(productEs.getName())
                .freeDelivery(productDeliveryService.freeDeliveryCheck(productEs.getId(), productEs.getPrice().get("USD"),MoneyTypes.USD))
                .image(productImageService.getProductMainImage(productEs.getId()))
                .seller(ProductSellerResponse.builder().id(productEs.getSeller().getId()).name(productEs.getName()).build())
                .build();
    }
}
