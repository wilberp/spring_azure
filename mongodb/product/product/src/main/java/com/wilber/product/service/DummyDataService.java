package com.wilber.product.service;

import com.wilber.product.document.ProdutoDocument;
import com.wilber.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Service
public class DummyDataService {

    @Autowired
    ProdutoRepository produtoRepository;
    
    //@PostConstruct
    //desabilitar qdo criar massa
    public void criarProdutos(){
        produtoRepository.deleteAll()
                .thenMany(
                        Flux.just("Lapis")
                        .map(produto -> new ProdutoDocument("1","Lapis", "Lapis de cor"))
                        .flatMap(produtoRepository::save))
                        .subscribe(System.out::println);
    }
}
