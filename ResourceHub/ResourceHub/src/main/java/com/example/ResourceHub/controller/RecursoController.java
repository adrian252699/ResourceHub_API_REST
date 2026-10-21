package com.example.ResourceHub.controller;

import com.example.ResourceHub.model.Recurso;
import com.example.ResourceHub.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping()
    public List<Recurso> listar() {
        return recursoService.findAll();
    }

    @GetMapping("/{id}")
    public Recurso buscarPorId(@PathVariable Long id) {
        return recursoService.findById(id);
    }

    @PostMapping
    public Recurso guardar(@RequestBody Recurso recurso) {
        return recursoService.crear(recurso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        recursoService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Recurso editar(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.editar(id, recurso).orElse(null);
    }

    @PatchMapping("/{id}")
    public Recurso editarParcial(@RequestBody Recurso recurso,@PathVariable Long id) {
        return recursoService.editarParcialmente(id, recurso).orElse(null);
    }
}