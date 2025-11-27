package com.blog.blog.Repository;

import com.blog.blog.Model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    Publicacao findByTitulo(String titulo);
}
