package com.wilber.product.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProdutoDocument {

    @Id
    private String id;
    private String nomeProduto;
    private String descricaoProduto;

    public ProdutoDocument(String id, String nomeProduto, String descricaoProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
}
