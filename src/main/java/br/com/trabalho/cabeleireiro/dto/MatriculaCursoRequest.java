package br.com.trabalho.cabeleireiro.dto;

import jakarta.validation.constraints.NotNull;

// Este objeto representa os dados enviados para matricular um cliente em um curso.
public class MatriculaCursoRequest {
    // Cliente que deseja comprar o curso.
    @NotNull(message = "Cliente e obrigatorio")
    private Long clienteId;

    // Curso escolhido.
    @NotNull(message = "Curso e obrigatorio")
    private Long cursoId;

    // Construtor vazio para conversao de JSON.
    public MatriculaCursoRequest() {
    }

    // Devolve o cliente da matricula.
    public Long getClienteId() {
        return clienteId;
    }

    // Altera o cliente da matricula.
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Devolve o curso da matricula.
    public Long getCursoId() {
        return cursoId;
    }

    // Altera o curso da matricula.
    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
