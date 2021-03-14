package com.wilber.product.controller;

import com.wilber.product.document.ProdutoDocument;
import com.wilber.product.service.ProdutoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produto")
@Api(value = "API REST Produtos endpoint")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl service;

    @GetMapping()

    public Flux<ProdutoDocument> getProdutos() {
        return service.findall();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna produto por Id")
    public Mono<ProdutoDocument> getProdutoPorId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Gravar produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProdutoDocument> saveProduto(@RequestBody ProdutoDocument produto){
        return service.save(produto);
    }

    @PutMapping
    @ApiOperation(value = "Altera produto")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ProdutoDocument> updateProduto(@RequestBody ProdutoDocument produto){
        return service.save(produto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Apaga produto por ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduto(@PathVariable String id){
        return service.delete(id);
    }
}
