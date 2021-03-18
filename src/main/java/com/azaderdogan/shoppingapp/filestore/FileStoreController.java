package com.azaderdogan.shoppingapp.filestore;

import com.azaderdogan.shoppingapp.filestore.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/filestore")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FileStoreController {
    final FileStoreService fileStoreService;

    @GetMapping("/{id}")
    public Mono<Void> getImage(@PathVariable String id, ServerWebExchange serverWebExchange) throws Exception {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.OK);
        serverHttpResponse.getHeaders().setContentType(MediaType.IMAGE_JPEG); // normadle json kullanıyorduk

        DataBufferFactory factory = new DefaultDataBufferFactory();
        return fileStoreService.getImage(id).flatMap(image -> serverHttpResponse.writeWith(Flux.just(factory.wrap(image))));
    }
}
