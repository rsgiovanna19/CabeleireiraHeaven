package br.com.trabalho.cabeleireiro.dto;

import java.math.BigDecimal;

// Esta e a resposta enviada depois que um curso e vendido.
public class MatriculaResumoResponse {
    private String curso;
    private String nivel;
    private BigDecimal valorFinal;
    private String status;

    // Construtor vazio para o Jackson.
    public MatriculaResumoResponse() {
    }

    // Construtor completo para montar a resposta da matricula.
    public MatriculaResumoResponse(String curso, String nivel, BigDecimal valorFinal, String status) {
        this.curso = curso;
        this.nivel = nivel;
        this.valorFinal = valorFinal;
        this.status = status;
    }

    // Devolve o nome do curso.
    public String getCurso() {
        return curso;
    }

    // Altera o nome do curso.
    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Devolve o nivel do curso.
    public String getNivel() {
        return nivel;
    }

    // Altera o nivel do curso.
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    // Devolve o valor final cobrado.
    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    // Altera o valor final cobrado.
    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    // Devolve o resultado final da matricula.
    public String getStatus() {
        return status;
    }

    // Altera o resultado final da matricula.
    public void setStatus(String status) {
        this.status = status;
    }
}
