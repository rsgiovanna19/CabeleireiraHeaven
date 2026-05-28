package br.com.trabalho.cabeleireiro.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuracao minima de fila, exchange e binding.
@Configuration
public class RabbitMQConfig {

    // Nome da exchange usada para publicar os eventos.
    public static final String EXCHANGE = "cabeleireiro.exchange";
    // Chave usada para enviar a mensagem para a fila certa.
    public static final String ROUTING_KEY = "agendamento.criado";
    // Nome da fila que vai guardar os eventos.
    public static final String QUEUE = "cabeleireiro.agendamentos";

    // Cria a exchange principal.
    @Bean
    public DirectExchange cabeleireiroExchange() {
        return new DirectExchange(EXCHANGE);
    }

    // Cria a fila dos agendamentos.
    @Bean
    public Queue agendamentoQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    // Liga a fila com a exchange usando a routing key.
    @Bean
    public Binding agendamentoBinding(Queue agendamentoQueue, DirectExchange cabeleireiroExchange) {
        return BindingBuilder.bind(agendamentoQueue).to(cabeleireiroExchange).with(ROUTING_KEY);
    }

    // Faz o RabbitMQ converter objetos Java para JSON automaticamente.
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
