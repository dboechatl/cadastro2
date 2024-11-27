package com.senac.diogoboechat.galeria.entities;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "obradearte")
public class ObraDeArte implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obra_id", nullable = false)
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "artista", nullable = false)
    private String artista;

    @Column(name = "ano_criacao", nullable = false)
    private int anoCriacao;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor_estimado", nullable = false)
    private Double valorEstimado;

    @Column(name = "status_disponibilidade", nullable = false)
    private int status;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    public ObraDeArte() {
    }

    public ObraDeArte(String titulo, String artista, int anoCriacao, String descricao, Double valorEstimado, int statusDisponibilidade, String categoria) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoCriacao = anoCriacao;
        this.descricao = descricao;
        this.valorEstimado = valorEstimado;
        this.status = statusDisponibilidade;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(Double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int statusDisponibilidade) {
        this.status = statusDisponibilidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
