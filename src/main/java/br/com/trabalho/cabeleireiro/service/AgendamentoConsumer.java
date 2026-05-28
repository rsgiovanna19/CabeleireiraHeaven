package br.com.trabalho.cabeleireiro.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.config.RabbitMQConfig;
import br.com.trabalho.cabeleireiro.dto.AgendamentoCriadoEvent;

// Consome eventos da fila para simular outro processo do sistema.
@Service
public class AgendamentoConsumer {

    // Escuta a fila e processa a mensagem quando um agendamento e criado.
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumirAgendamentoCriado(AgendamentoCriadoEvent event) {
        System.out.println("Mensagem RabbitMQ recebida: agendamento " + event.getAgendamentoId()
                + " para cliente " + event.getClienteId()
                + " em " + event.getDataHora());
    }
}
