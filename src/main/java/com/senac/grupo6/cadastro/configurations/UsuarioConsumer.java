package com.senac.grupo6.cadastro.configurations;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UsuarioConsumer {

    @RabbitListener(queues = "usuarioFila")
    public void processarMensagem(String mensagem) {
        System.out.println("Recebida mensagem: " + mensagem);
        // Aqui você pode processar a mensagem ou realizar outras ações necessárias
    }
}