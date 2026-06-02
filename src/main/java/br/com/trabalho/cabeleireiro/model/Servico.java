package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;

// Representa um servico prestado pelo salao.
public class Servico {
    private Long id;
    private String nome;
    private BigDecimal precoBase;
    private String categoria;

    public Servico() {
    }

    public Servico(Long id, String nome, BigDecimal precoBase, String categoria) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
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

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
