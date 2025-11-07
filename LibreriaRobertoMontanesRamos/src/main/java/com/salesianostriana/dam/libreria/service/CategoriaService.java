package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Optional<Categoria> findByNombre(String nombre);
    Categoria save(Categoria categoria);
    Categoria edit(Categoria categoria);
    void delete(Categoria categoria);
    void deleteById(Long id);
}