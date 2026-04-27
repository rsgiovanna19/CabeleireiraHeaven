package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;

// Representa um produto vendido pelo salao.
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int estoque;
    private String categoria;

    // Construtor vazio para criacao automatica.
    public Produto() {
    }

    // Construtor completo.
    public Produto(Long id, String nome, BigDecimal preco, int estoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    //getters e setters para acessar e modificar os atributos do produto

    // Devolve o codigo do produto.
    public Long getId() {
        return id;
    }

    // Altera o codigo do produto.
    public void setId(Long id) {
        this.id = id;
    }

    // Devolve o nome do produto.
    public String getNome() {
        return nome;
    }

    // Altera o nome do produto.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Devolve o preco do produto.
    public BigDecimal getPreco() {
        return preco;
    }

    // Altera o preco do produto.
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    // Devolve a quantidade em estoque.
    public int getEstoque() {
        return estoque;
    }

    // Altera a quantidade em estoque.
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    // Devolve a categoria do produto.
    public String getCategoria() {
        return categoria;
    }

    // Altera a categoria do produto.
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
