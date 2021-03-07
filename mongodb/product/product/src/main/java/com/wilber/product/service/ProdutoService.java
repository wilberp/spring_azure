package com.wilber.product.service;

import com.wilber.product.document.ProdutoDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProdutoService {

    Flux<ProdutoDocument> findall();
    Mono<ProdutoDocument> findById(String id);
    Mono<ProdutoDocument> save(ProdutoDocument produto);
    Mono<Void> delete(String id);
}
