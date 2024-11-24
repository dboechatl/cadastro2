package com.senac.grupo6.cadastro.configurations;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UsuarioProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagemNovoUsuario(String mensagem) {
        // Enviar a mensagem para a fila "usuarioFila"
        rabbitTemplate.convertAndSend("usuarioExchange", "usuarioRoutingKey", mensagem);
    }
}
