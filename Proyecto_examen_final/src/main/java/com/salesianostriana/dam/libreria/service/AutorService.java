package com.salesianostriana.dam.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.libreria.model.Autor;
import com.salesianostriana.dam.libreria.repository.AutorRepository;
import com.salesianostriana.dam.libreria.repository.LibroRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService { // Solo una clase, sin interfaz ni @Transactional

    @Autowired
    private AutorRepository autorRepository; // Repositorio de Autores

    @Autowired
    private LibroRepository libroRepository; // Repositorio de Libros

    // -------------------------------------------------------------------------
    // MÉTODOS CRUD BÁSICOS
    // -------------------------------------------------------------------------

    // Obtiene todos los autores y los devuelve ordenados por nombre
    public List<Autor> findAll() {
        return autorRepository.findAll()
                .stream()
                .sorted((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()))
                .collect(Collectors.toList());
    }

    // Busca un autor por su ID (devuelve Optional para evitar NullPointer)
    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    // Guarda o actualiza un autor (con validación)
    public Autor save(Autor autor) {
        if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío");
        }
        return autorRepository.save(autor);
    }

    // Elimina un autor por ID
    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    // -------------------------------------------------------------------------
    // LÓGICA DE NEGOCIO ESPECÍFICA
    // -------------------------------------------------------------------------

    // Comprueba si el autor puede ser eliminado (solo si no tiene libros)
    public boolean puedeSerEliminado(Long id) {
        return autorRepository.findById(id)
                .map(autor -> autor.getLibros().isEmpty())
                .orElse(false);
    }

    // Devuelve los autores con al menos 'minLibros' libros, ordenados por cantidad de libros (desc)
    public List<Autor> buscarAutoresPopulares(int minLibros) {
        return autorRepository.findAll()
                .stream()
                .filter(autor -> autor.getLibros().size() >= minLibros)
                .sorted((a1, a2) -> Integer.compare(a2.getLibros().size(), a1.getLibros().size()))
                .collect(Collectors.toList());
    }

    // Calcula los ingresos totales del autor como 10% del precio de sus libros
    public double calcularIngresosTotales(Long autorId) {
        return libroRepository.findByAutorId(autorId)
                .stream()
                .mapToDouble(libro -> libro.getPrecio() * 0.1) // regalía 10%
                .sum();
    }
}
