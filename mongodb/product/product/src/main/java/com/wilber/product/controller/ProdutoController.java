package com.wilber.product.controller;

import com.wilber.product.document.ProdutoDocument;
import com.wilber.product.service.ProdutoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl service;

    @GetMapping()
    @Operation(summary =  "Retorna lista de produtos")
    @ApiResponse(responseCode = "200", description = "Produtos",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProdutoDocument.class)) })
    public Flux<ProdutoDocument> getProdutos() {
        return service.findall();
    }

    @GetMapping("/{id}")
    @Operation(summary =  "Retorna produto por Id")
    @ApiResponse(responseCode = "200", description = "Produto por Id",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = ProdutoDocument.class)) })
    public Mono<ProdutoDocument> getProdutoPorId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary =  "Gravar produto")
    @ApiResponse(responseCode = "201", description = "Produto incluido",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProdutoDocument.class)) })
    public Mono<ProdutoDocument> saveProduto(@RequestBody ProdutoDocument produto){
        return service.save(produto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Altera produto")
    @ApiResponse(responseCode = "202", description = "Produto alterado",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProdutoDocument.class)) })
    public Mono<ProdutoDocument> updateProduto(@RequestBody ProdutoDocument produto){
        return service.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary =  "Apaga produto por ID")
    @ApiResponse(responseCode = "204", description = "Produto excluido",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProdutoDocument.class)) })
    public Mono<Void> deleteProduto(@PathVariable String id){
        return service.delete(id);
    }
}
