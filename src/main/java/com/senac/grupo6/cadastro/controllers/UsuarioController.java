package com.senac.grupo6.cadastro.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.grupo6.cadastro.entities.Usuario;
import com.senac.grupo6.cadastro.services.UsuarioService;



@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuariosAtivos(); // Apenas usuários ativos
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.listarUsuarioPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "adicionarUsuario")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
        Usuario tempUsuario = usuarioService.adicionarUsuario(usuario);
        return ResponseEntity.ok(tempUsuario);
    }

    // Apagado lógico: altera o status do usuário para 0
    @DeleteMapping(value = "apagarUsuario/{id}")
    public ResponseEntity<String> apagarUsuario(@PathVariable int id) {
        String result = usuarioService.apagarUsuarioLogicamente(id);
        if (result.equals("Usuário não encontrado")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "atualizarUsuario/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario tempUsuario = usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok(tempUsuario);
    }
}