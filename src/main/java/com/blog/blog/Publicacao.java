package com.blog.blog;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class Publicacao { 

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 3, max = 120)
    private String titulo;

    @NotBlank
    @Size(min = 10)
    private String texto;

    @NotBlank
    @Size(min = 3, max = 100)
    private String autor;

    @NotNull
    @PastOrPresent
    private LocalDate dataPublicacao;

    private boolean publicado;

    public Publicacao() {
    }

    public Publicacao(Long id, String titulo, String texto, String autor, LocalDate dataPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.publicado = !dataPublicacao.isAfter(LocalDate.now()); 
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
}
