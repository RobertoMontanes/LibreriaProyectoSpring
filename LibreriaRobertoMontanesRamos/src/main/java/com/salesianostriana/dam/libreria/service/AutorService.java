package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Autor;
import java.util.List;
import java.util.Optional;

public interface AutorService {
    
    // CRUD básico
    List<Autor> findAll();
    Optional<Autor> findById(Long id);
    Autor save(Autor autor);
    Autor edit(Autor autor);
    void delete(Autor autor);
    void deleteById(Long id);
    
    // Métodos específicos de negocio
    List<Autor> buscarPorNombre(String nombre);
    List<Autor> buscarPorNacionalidad(String nacionalidad);
    boolean tieneLibros(Long id);
    List<Autor> findAutoresConLibros();
}