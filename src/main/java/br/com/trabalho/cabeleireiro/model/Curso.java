package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;

// Representa um curso vendido para profissionais.
public class Curso {
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private int vagas;
    private String nivel;

    public Curso() {
    }

    public Curso(Long id, String titulo, BigDecimal preco, int vagas, String nivel) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.vagas = vagas;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
