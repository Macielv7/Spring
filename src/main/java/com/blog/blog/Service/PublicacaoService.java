package com.blog.blog.Service;

import java.util.List;

import com.blog.blog.Model.Publicacao;

public interface PublicacaoService {

    List<Publicacao> findAll();

    Publicacao findById(Long id);

    Publicacao findByTitulo(String titulo);

    Publicacao addNew(Publicacao publicacao);

    Publicacao update(Long id, Publicacao publicacao);

    void delete(Long id);
}
