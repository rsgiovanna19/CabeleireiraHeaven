//importando pacotes necessários para a classe
package br.com.trabalho.cabeleireiro.dto;
import jakarta.validation.constraints.NotNull;

//DTO = Data Transfer Object. Um objeto que carrega os dados necessarios, neste caso, do agendamento. Somente guarda informação.
// Este objeto representa os dados enviados para matricular um cliente em um curso.

public class MatriculaCursoRequest {
    // Cliente que deseja comprar o curso.
    @NotNull(message = "Cliente é obrigatorio") //evita que retorne vazio ou nulo
    private Long clienteId;

    // Curso escolhido.
    @NotNull(message = "Curso é obrigatorio")  //evita que retorne vazio ou nulo
    private Long cursoId;

    // Construtor vazio para conversao de JSON -
    public MatriculaCursoRequest() {
    }

    // Devolve o cliente pelo id da matricula
    public Long getClienteId() {
        return clienteId;
    }

    // Altera o cliente da matricula por id
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Devolve o curso da matricula por id
    public Long getCursoId() {
        return cursoId;
    }

    // Altera o curso da matricula por id
    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
