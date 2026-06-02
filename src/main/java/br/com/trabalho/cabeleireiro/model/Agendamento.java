package br.com.trabalho.cabeleireiro.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Representa a marcacao de um atendimento no salao.
public class Agendamento {
    private Long id;
    private Long clienteId;
    private Long servicoId;
    private LocalDateTime dataHora;
    private String observacoes;
    private AgendamentoStatus status;
    private BigDecimal valorCobrado;

    public Agendamento() {
    }

    public Agendamento(Long id, Long clienteId, Long servicoId, LocalDateTime dataHora, String observacoes,
            AgendamentoStatus status, BigDecimal valorCobrado) {
        this.id = id;
        this.clienteId = clienteId;
        this.servicoId = servicoId;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
        this.status = status;
        this.valorCobrado = valorCobrado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public AgendamentoStatus getStatus() {
        return status;
    }

    public void setStatus(AgendamentoStatus status) {
        this.status = status;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }
}
