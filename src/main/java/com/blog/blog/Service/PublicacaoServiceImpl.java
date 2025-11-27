package com.blog.blog.Service;

import com.blog.blog.Model.Publicacao;
import com.blog.blog.Repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacaoServiceImpl implements PublicacaoService {

    @Autowired
    private PublicacaoRepository repository;

    @Override
    public List<Publicacao> findAll() {
        return repository.findAll();
    }

    @Override
    public Publicacao findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Publicacao findByTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    @Override
    public Publicacao addNew(Publicacao publicacao) {
        return repository.save(publicacao);
    }

    @Override
    public Publicacao update(Long id, Publicacao publicacao) {
        return repository.findById(id).map(existing -> {
            existing.setTitulo(publicacao.getTitulo());
            existing.setTexto(publicacao.getTexto());
            existing.setAutor(publicacao.getAutor());
            existing.setDataPublicacao(publicacao.getDataPublicacao());
            return repository.save(existing);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
