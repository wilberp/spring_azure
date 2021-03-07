package com.wilber.product.service;

import com.wilber.product.document.ProdutoDocument;
import com.wilber.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Flux<ProdutoDocument> findall(){
       return  produtoRepository.findAll();
    }

    @Override
    public Mono<ProdutoDocument> findById(String id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Mono<ProdutoDocument> save(ProdutoDocument produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Mono<Void> delete (String id){
        return produtoRepository.deleteById(id);
    }

}
