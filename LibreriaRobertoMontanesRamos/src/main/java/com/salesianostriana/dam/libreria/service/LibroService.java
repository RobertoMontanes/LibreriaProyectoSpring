package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroService {
    
    // CRUD básico
    List<Libro> findAll();
    Optional<Libro> findById(Long id);
    Libro save(Libro libro);
    Libro edit(Libro libro);
    void delete(Libro libro);
    void deleteById(Long id);
    
    // Métodos específicos de negocio
    List<Libro> buscarPorTitulo(String titulo);
    List<Libro> buscarPorPrecioBetween(Double min, Double max);
    List<Libro> buscarPorAutorNombre(String nombreAutor);
    List<Libro> buscarPorCategoriaNombre(String categoriaNombre);
    List<Libro> findLibrosConMasPaginasQue(int paginas);
    List<Libro> findAllOrderByPrecioDesc();
    List<Libro> findAllOrderByTituloAsc();
}