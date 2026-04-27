package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;

// Representa um servico prestado pelo salao,
// como corte, hidratacao ou tintura.
public class Servico {
    private Long id;
    private String nome;
    private BigDecimal precoBase;
    private String categoria;

    // Construtor vazio para criacao automatica.
    public Servico() {
    }

    // Construtor completo.
    public Servico(Long id, String nome, BigDecimal precoBase, String categoria) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
        this.categoria = categoria;
    }

    //getters e setters para acessar e modificar os atributos do servico

    // Devolve o codigo do servico.
    public Long getId() {
        return id;
    }

    // Altera o codigo do servico.
    public void setId(Long id) {
        this.id = id;
    }

    // Devolve o nome do servico.
    public String getNome() {
        return nome;
    }

    // Altera o nome do servico.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Devolve o preco base do servico.
    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    // Altera o preco base do servico.
    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    // Devolve a categoria do servico.
    public String getCategoria() {
        return categoria;
    }

    // Altera a categoria do servico.
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
