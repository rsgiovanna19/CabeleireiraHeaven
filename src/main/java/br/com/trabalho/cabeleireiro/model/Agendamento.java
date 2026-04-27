//imports necessários para a aplicação
package br.com.trabalho.cabeleireiro.model; //importa o cabeleireiro.model, onde estao as classes de modelo.

import java.math.BigDecimal;
import java.time.LocalDateTime;


//construtores

// Representa a marcacao de um atendimento no salao.
// Ele liga um cliente a um servico em uma data e hora.
public class Agendamento {
    private Long id;
    private Long clienteId;
    private Long servicoId;
    private LocalDateTime dataHora;
    private String observacoes;
    private AgendamentoStatus status;
    private BigDecimal valorCobrado;

    // Construtor vazio para criacao automatica.
    public Agendamento() {
    }

    // Construtor completo.
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


//getters e setters para acessar e modificar os atributos do agendamento
    // Devolve o codigo do agendamento por id
    public Long getId() {
        return id;
    }

    // Altera o codigo do agendamento por id
    public void setId(Long id) {
        this.id = id;
    }

    // Devolve o codigo do cliente ligado ao agendamento por id
    public Long getClienteId() {
        return clienteId;
    }

    // Altera o cliente ligado ao agendamento por id
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Devolve o codigo do servico ligado ao agendamento por id
    public Long getServicoId() {
        return servicoId;
    }

    // Altera o servico ligado ao agendamento por id
    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    // Devolve a data e hora marcadas.
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // Altera a data e hora marcadas.
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // Devolve observacoes extras sobre o atendimento.
    public String getObservacoes() {
        return observacoes;
    }

    // Altera as observacoes do atendimento.
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // Devolve o status atual do agendamento.
    public AgendamentoStatus getStatus() {
        return status;
    }

    // Altera o status do agendamento.
    public void setStatus(AgendamentoStatus status) {
        this.status = status;
    }

    // Devolve o valor final cobrado.
    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    // Altera o valor final cobrado.
    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }
}
