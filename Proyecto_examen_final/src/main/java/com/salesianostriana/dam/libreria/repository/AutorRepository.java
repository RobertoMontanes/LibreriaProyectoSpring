package com.salesianostriana.dam.libreria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.salesianostriana.dam.libreria.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
    List<Autor> findByNombreContainingIgnoreCase(String nombre);
    List<Autor> findByNacionalidad(String nacionalidad);
    
    @Query("SELECT a FROM Autor a WHERE SIZE(a.libros) > 0")
    List<Autor> findAutoresConLibros();  
    
    List<Autor> findAll();
}

/*
 * Buscar autores por nombre
 * Buscar autores por nacionalidad
 * Buscar autores que tengan al menos un libro asociado
 * Listar todos los autores
 */