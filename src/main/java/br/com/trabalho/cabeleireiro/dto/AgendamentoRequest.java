//importando pacotes necessários

package br.com.trabalho.cabeleireiro.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;


//DTO = Data Transfer Object. Um objeto que carrega os dados necessarios, neste caso, do agendamento. Somente guarda informação
//Este objeto representa os dados que o usuario envia para realizar ou atualizar um agendamento

public class AgendamentoRequest {
    // Identifica qual cliente esta marcando o horario.
    @NotNull(message = "Cliente é obrigatorio") //garante que o cliente seja informado na requisicao, sem ser nulo
    private Long clienteId;     //private long = atributo numérico com valor grande.

    // Identifica qual servico sera realizado - corte, hidratacao, etc...
    @NotNull(message = "Servico é obrigatorio") //garante que o serviço seja informado na requisicao, sem ser nulo
    private Long servicoId;

    // Define quando o atendimento vai acontecer.
    @NotNull(message = "Data e hora sao obrigatorias")  //garante que a data e hora sejam informados na requisicao, sem ser nulo
    @Future(message = "O agendamento precisa ser em data futura") //garante que o agendamento nao tenha data passada
    private LocalDateTime dataHora;

    // Campo para observacoes do agendamento
    private String observacoes;

    // Construtor vazio p instanciar o objeto. Instanciar = criar um objeto a partir da classe, alocando memoria para ele.
    //Jackson = biblioteca que converte JSON em objetos Java e vice-versa.
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
