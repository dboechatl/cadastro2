package com.senac.grupo6.cadastro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.grupo6.cadastro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	List<Usuario> findByStatus(int status);

}