package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Categoria;
import com.salesianostriana.dam.libreria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService { // Clase única, sin interfaz ni @Transactional

    @Autowired
    private CategoriaRepository categoriaRepository; // Inyectamos el repositorio de Categoría

    // -------------------------------------------------------------------------
    // MÉTODOS CRUD BÁSICOS
    // -------------------------------------------------------------------------

    // Devuelve todas las categorías de la base de datos
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Busca una categoría por su ID (devuelve Optional para evitar nulls)
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    // Busca una categoría por su nombre
    public Optional<Categoria> findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    // Guarda una nueva categoría o actualiza una existente si tiene ID
    public Categoria save(Categoria categoria) {
        // Validación simple: no permitir nombre vacío
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío");
        }
        return categoriaRepository.save(categoria);
    }

    // Edita una categoría existente (realmente hace lo mismo que save)
    public Categoria edit(Categoria categoria) {
        // Podrías añadir aquí una comprobación de existencia antes de editar
        return categoriaRepository.save(categoria);
    }

    // Elimina una categoría (pasando el objeto)
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }

    // Elimina una categoría por su ID
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
