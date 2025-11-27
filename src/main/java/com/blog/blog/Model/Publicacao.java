package com.blog.blog.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "publicacoes")
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "titulo é obrigatório")
    private String titulo;

    @Column(nullable = false, length = 10000)
    @NotBlank(message = "texto é obrigatório")
    @Size(min = 10, message = "texto deve ter no mínimo 10 caracteres")
    private String texto;

    @Column(nullable = false)
    @NotBlank(message = "autor é obrigatório")
    private String autor;

    @Column(nullable = false)
    @NotNull(message = "dataPublicacao é obrigatória")
    private LocalDateTime dataPublicacao;

    public Publicacao() {
    }

    public Publicacao(String titulo, String texto, String autor, LocalDateTime dataPublicacao) {
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
