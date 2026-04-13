package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;

// Representa um curso vendido para profissionais da area.
public class Curso {
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private int vagas;
    private String nivel;

    // Construtor vazio para criacao automatica.
    public Curso() {
    }

    // Construtor completo.
    public Curso(Long id, String titulo, BigDecimal preco, int vagas, String nivel) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.vagas = vagas;
        this.nivel = nivel;
    }

    // Devolve o codigo do curso.
    public Long getId() {
        return id;
    }

    // Altera o codigo do curso.
    public void setId(Long id) {
        this.id = id;
    }

    // Devolve o titulo do curso.
    public String getTitulo() {
        return titulo;
    }

    // Altera o titulo do curso.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Devolve o preco do curso.
    public BigDecimal getPreco() {
        return preco;
    }

    // Altera o preco do curso.
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    // Devolve o numero de vagas restantes.
    public int getVagas() {
        return vagas;
    }

    // Altera a quantidade de vagas.
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    // Devolve o nivel do curso.
    public String getNivel() {
        return nivel;
    }

    // Altera o nivel do curso.
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
