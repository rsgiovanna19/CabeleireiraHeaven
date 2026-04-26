//importando pacotes necessários para a classe de resposta da matricula

package br.com.trabalho.cabeleireiro.dto;
import java.math.BigDecimal;

//DTO = Data Transfer Object, ou seja, um objeto usado para transferir dados entre camadas da aplicação
// Esta e a resposta enviada depois que um curso e vendido.

// Essa classe representa a resposta que o sistema envia depois que um curso e vendido. 
// Ela contém informações sobre o curso, o nivel, o valor final cobrado e o status da matricula. 
// O status pode ser "Aprovada", "Reprovada" ou "Pendente", dependendo do resultado da matricula. 
// O valor final pode ser diferente do valor original do curso, dependendo de descontos ou promoções aplicados.
public class MatriculaResumoResponse {
    private String curso;
    private String nivel;
    private BigDecimal valorFinal;
    private String status;

    // Construtor vazio para o Jackson retornar sem erros
    public MatriculaResumoResponse() {
    }

    // Construtor completo para montar a resposta da matricula 
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
