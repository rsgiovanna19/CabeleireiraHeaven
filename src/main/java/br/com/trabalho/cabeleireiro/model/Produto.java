package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;

// Representa um produto vendido pelo salao.
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int estoque;
    private String categoria;

    public Produto() {
    }

    public Produto(Long id, String nome, BigDecimal preco, int estoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
