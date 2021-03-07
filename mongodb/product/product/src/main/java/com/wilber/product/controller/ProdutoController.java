package com.wilber.product.controller;

import com.wilber.product.document.ProdutoDocument;
import com.wilber.product.service.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl service;

    @GetMapping()
    public Flux<ProdutoDocument> getProdutos() {
        return service.findall();
    }

    @GetMapping("/{id}")
    public Mono<ProdutoDocument> getProdutoPorId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProdutoDocument> saveProduto(@RequestBody ProdutoDocument produto){
        return service.save(produto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ProdutoDocument> updateProduto(@RequestBody ProdutoDocument produto){
        return service.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduto(@PathVariable String id){
        return service.delete(id);
    }
}
