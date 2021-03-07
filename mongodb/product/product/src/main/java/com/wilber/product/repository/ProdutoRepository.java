package com.wilber.product.repository;

import com.wilber.product.document.ProdutoDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProdutoRepository extends ReactiveMongoRepository<ProdutoDocument, String> {
}
