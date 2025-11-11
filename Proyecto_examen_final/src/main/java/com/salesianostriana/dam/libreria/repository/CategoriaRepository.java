package com.salesianostriana.dam.libreria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.libreria.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Optional<Categoria> findByNombreIgnoreCase(String nombre);
    Optional<Categoria> findByNombre(String nombre); 

}

/*
 * Buscar categoría por nombre
 */
