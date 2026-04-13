package br.com.trabalho.cabeleireiro.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

// Este objeto representa os dados que o usuario envia
// para criar ou atualizar um agendamento.
public class AgendamentoRequest {
    // Identifica qual cliente esta marcando o horario.
    @NotNull(message = "Cliente e obrigatorio")
    private Long clienteId;

    // Identifica qual servico sera realizado.
    @NotNull(message = "Servico e obrigatorio")
    private Long servicoId;

    // Define quando o atendimento vai acontecer.
    @NotNull(message = "Data e hora sao obrigatorias")
    @Future(message = "O agendamento precisa ser em data futura")
    private LocalDateTime dataHora;

    // Campo livre para observacoes.
    private String observacoes;

    // Construtor vazio para o Jackson converter JSON em objeto.
    public AgendamentoRequest() {
    }

    // Devolve o cliente informado na requisicao.
    public Long getClienteId() {
        return clienteId;
    }

    // Altera o cliente informado na requisicao.
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Devolve o servico informado na requisicao.
    public Long getServicoId() {
        return servicoId;
    }

    // Altera o servico informado na requisicao.
    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    // Devolve a data e hora do atendimento.
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // Altera a data e hora do atendimento.
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // Devolve a observacao escrita pelo usuario.
    public String getObservacoes() {
        return observacoes;
    }

    // Altera a observacao escrita pelo usuario.
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
