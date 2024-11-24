package com.senac.grupo6.cadastro.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Definir a fila
    @Bean
    public Queue queue() {
        return new Queue("usuarioFila", false); // 'false' significa que a fila não será durável
    }

    // Definir a exchange (usaremos uma exchange do tipo Direct)
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("usuarioExchange");
    }

    // Ligação entre a fila e a exchange
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("usuarioRoutingKey");
    }
}
