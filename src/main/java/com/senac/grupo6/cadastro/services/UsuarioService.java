package com.senac.grupo6.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senac.grupo6.cadastro.configurations.UsuarioProducer;
import com.senac.grupo6.cadastro.entities.Usuario;
import com.senac.grupo6.cadastro.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private final UsuarioProducer usuarioProducer;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioProducer usuarioProducer) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioProducer = usuarioProducer;
    }

    // Lista apenas usuários ativos (status = 1)
    public List<Usuario> listarUsuariosAtivos() {
        return usuarioRepository.findByStatus(1);
    }
    
    public Usuario listarUsuarioPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        usuario.setStatus(1); // Define status como ativo ao adicionar
        
        // Enviar uma mensagem de aviso para a fila RabbitMQ
        String mensagem = "Novo usuário criado: " + usuario.getNome() + " " + usuario.getSobrenome();
        usuarioProducer.enviarMensagemNovoUsuario(mensagem);
        
        return usuarioRepository.save(usuario);
    }
	
	// Apagado lógico: altera o status para -1
    public String apagarUsuarioLogicamente(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "Usuário não encontrado";
        }
        usuario.setStatus(-1); // Define status como apagado
        usuarioRepository.save(usuario);
        return "Usuário apagado logicamente com sucesso!";
    }
	
//	public String apagarUsuario(int id) {
//		try {
//			usuarioRepository.deleteById(id);
//			return "Usuário id: "+id+"apagado com sucesso.";
//		} catch(Error e) {
//			return e.getMessage().toString();
//		}
//	}
	
	public Usuario atualizarUsuario(int id, Usuario usuario) {
		if (usuarioRepository.existsById(id)) {
			return (usuarioRepository.save(usuario));
		} else {
			return null;
		}		
	}
	
}