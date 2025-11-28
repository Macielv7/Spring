package com.blog.blog.Controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog.blog.Model.Publicacao;
import com.blog.blog.Service.PublicacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/publicacoes")
@CrossOrigin(origins = "*")
public class PublicacaoRestController {

    @Autowired
    private PublicacaoService service;

    @GetMapping
    public List<Publicacao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Publicacao findById(@PathVariable("id") Long id) {
        Publicacao resultado = service.findById(id);
        if (resultado == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Publicação ID %s não encontrada".formatted(id)
            );
        }
        return resultado;
    }

    @GetMapping("/detalhes/{id}")
    public Map<String, Object> findDetalhes(
        @PathVariable("id") Long id,
        @RequestParam(value = "extra1", defaultValue = "xpto") String extra1,
        @RequestParam(value = "extra2", required = false) String extra2,
        @RequestHeader("user-agent") String userAgent) {

        Map<String, Object> mapResposta = new HashMap<>();
        mapResposta.put("publicacao", service.findById(id));
        mapResposta.put("extra1", extra1);
        mapResposta.put("extra2", extra2);
        mapResposta.put("user-agent", userAgent);
        return mapResposta;
    }

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody @Valid Publicacao publicacao) {
        Publicacao p = service.addNew(publicacao);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{id}")
            .buildAndExpand(p.getId())
            .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody @Valid Publicacao publicacao) {
        
        Publicacao p = service.findById(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }

        service.update(id, publicacao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
