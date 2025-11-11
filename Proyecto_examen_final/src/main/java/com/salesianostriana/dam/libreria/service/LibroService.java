package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Libro;
import com.salesianostriana.dam.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService { 

    @Autowired
    private LibroRepository libroRepository; 

    // -------------------------------------------------------------------------
    // MÉTODOS CRUD BÁSICOS
    // -------------------------------------------------------------------------

    // Devuelve todos los libros
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    // Busca un libro por su ID
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    // Guarda un nuevo libro o actualiza uno existente
    public Libro save(Libro libro) {
        // Validación simple antes de guardar
        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
        return libroRepository.save(libro);
    }

    // Edita un libro existente (igual que save)
    public Libro edit(Libro libro) {
        return libroRepository.save(libro);
    }

    // Elimina un libro pasando el objeto
    public void delete(Libro libro) {
        libroRepository.delete(libro);
    }

    // Elimina un libro por su ID
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    // -------------------------------------------------------------------------
    // MÉTODOS DE NEGOCIO ESPECÍFICOS
    // -------------------------------------------------------------------------

    // Busca libros cuyo título contenga una palabra o frase (sin distinguir mayúsculas)
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    // Busca libros cuyo precio esté entre dos valores
    public List<Libro> buscarPorPrecioBetween(Double min, Double max) {
        return libroRepository.findByPrecioBetween(min, max);
    }

    // Busca libros por nombre del autor (sin distinguir mayúsculas/minúsculas)
    public List<Libro> buscarPorAutorNombre(String nombreAutor) {
        return libroRepository.findByAutorNombreContainingIgnoreCase(nombreAutor);
    }

    // Busca libros pertenecientes a una categoría concreta (por nombre exacto de la categoría)
    public List<Libro> buscarPorCategoriaNombre(String categoriaNombre) {
        return libroRepository.findByCategoriaNombre(categoriaNombre);
    }

    // Busca libros que tengan más páginas que el número indicado
    public List<Libro> findLibrosConMasPaginasQue(int paginas) {
        return libroRepository.findLibrosConMasPaginasQue(paginas);
    }

    // Devuelve todos los libros ordenados por precio descendente
    public List<Libro> findAllOrderByPrecioDesc() {
        return libroRepository.findAllByOrderByPrecioDesc();
    }

    // Devuelve todos los libros ordenados por título ascendente
    public List<Libro> findAllOrderByTituloAsc() {
        return libroRepository.findAllByOrderByTituloAsc();
    }
}
