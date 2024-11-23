package com.senac.grupo6.cadastro.entities;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private int id;

    @Column(name = "usuario_nome", nullable = false)
    private String nome;
    
    @Column(name = "usuario_sobrenome", nullable = false)
    private String sobrenome;
    
    @Column(name = "usuario_cpf", nullable = false)
    private String cpf;
    
    @Column(name = "usuario_email", nullable = false)
    private String email;
    
    @Column(name = "usuario_senha", nullable = false)
    private String senha;
    
    @Column(name = "usuario_endereco", nullable = false)
    private String endereco;
    
    @Column(name = "usuario_telefone", nullable = false)
    private String telefone;

    @Column(name = "usuario_status", nullable = false)
    private int status;
    
    public Usuario(String nome, String sobrenome, String cpf, String email, String senha, String endereco, String telefone, int status) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}    
        
}