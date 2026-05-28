package br.com.trabalho.cabeleireiro.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.trabalho.cabeleireiro.config.RabbitMQConfig;
import br.com.trabalho.cabeleireiro.dto.AgendamentoCriadoEvent;

// Publica eventos de agendamento para outras aplicacoes.
@Service
public class AgendamentoPublisher {

    private final RabbitTemplate rabbitTemplate;

    public AgendamentoPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Envia o evento de criacao do agendamento para o RabbitMQ.
    public void publicarCriacao(AgendamentoCriadoEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, event);
    }
}
