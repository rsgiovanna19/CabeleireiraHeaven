package br.com.trabalho.cabeleireiro.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Evento enviado de forma assincrona ao criar um agendamento.
public class AgendamentoCriadoEvent {
    // Id do agendamento criado.
    private Long agendamentoId;
    // Cliente ligado ao agendamento.
    private Long clienteId;
    // Servico ligado ao agendamento.
    private Long servicoId;
    // Data e hora do atendimento.
    private LocalDateTime dataHora;
    // Valor calculado para o atendimento.
    private BigDecimal valorCobrado;
    // Status gerado no momento da criacao.
    private String status;

    public AgendamentoCriadoEvent() {
    }

    // Construtor usado para montar a mensagem enviada para a fila.
    public AgendamentoCriadoEvent(Long agendamentoId, Long clienteId, Long servicoId, LocalDateTime dataHora,
            BigDecimal valorCobrado, String status) {
        this.agendamentoId = agendamentoId;
        this.clienteId = clienteId;
        this.servicoId = servicoId;
        this.dataHora = dataHora;
        this.valorCobrado = valorCobrado;
        this.status = status;
    }

    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
