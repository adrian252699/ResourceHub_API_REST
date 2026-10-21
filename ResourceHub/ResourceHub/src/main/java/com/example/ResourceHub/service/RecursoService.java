package com.example.ResourceHub.service;

import com.example.ResourceHub.Repository.RecursoRepository;
import com.example.ResourceHub.model.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> findAll() {
        return recursoRepository.findAll();
    }

    public Recurso findById(Long id) {
        return recursoRepository.findById(id).orElse(null);
    }

    public Recurso crear(Recurso recurso) {

        //Validaciones

        return recursoRepository.save(recurso);
    }

    public void eliminar(Long id) {
        recursoRepository.deleteById(id);
    }

    public Optional<Recurso> editar(Long id, Recurso recurso) {

        return recursoRepository.findById(id).map(recurso1 -> {
            recurso1.setTitulo(recurso.getTitulo());
            recurso1.setUrl(recurso.getUrl());
            recurso1.setCategoria(recurso.getCategoria());
            recurso1.setTipo(recurso.getTipo());

            return recursoRepository.save(recurso1);
        });
    }

    public Optional<Recurso> editarParcialmente(Long id, Recurso recurso) {

        return recursoRepository.findById(id).map(recurso1 -> {
            if (recurso.getTitulo() != null) {
                recurso1.setTitulo(recurso.getTitulo());
            }

            if (recurso.getUrl() != null) {
                recurso1.setUrl(recurso.getUrl());
            }

            if (recurso.getCategoria() != null) {
                recurso1.setCategoria(recurso.getCategoria());
            }

            if (recurso.getTipo() != null) {
                recurso1.setTipo(recurso.getTipo());
            }

            return recursoRepository.save(recurso1);
        });
    }
}
