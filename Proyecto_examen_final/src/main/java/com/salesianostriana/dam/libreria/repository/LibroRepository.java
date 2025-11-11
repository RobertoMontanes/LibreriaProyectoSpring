package com.salesianostriana.dam.libreria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByPrecioBetween(Double min, Double max);
    List<Libro> findByAutorNombreContainingIgnoreCase(String nombreAutor);
    List<Libro> findByAutorId(Long autorId);
    
    List<Libro> findByCategoriaNombre(String categoriaNombre);
    List<Libro> findAllByOrderByPrecioDesc();
    List<Libro> findAllByOrderByTituloAsc();
    List<Libro> findAllByOrderByPaginasAsc();

    @Query("SELECT l FROM Libro l WHERE l.paginas > :paginas ORDER BY l.precio DESC")
    List<Libro> findLibrosConMasPaginasQue(@Param("paginas") int paginas);
}


/*
 * Buscar libros por título
 * Buscar libros por rango de precio
 * Buscar libros por nombre del autor
 * Buscar libros por nombre de la categoría
 * Listar todos los libros ordenados por precio descendente
 * Listar todos los libros ordenados por título ascendente
 * Listar todos los libros ordenados por número de páginas ascendente
 * Buscar libros con más de un número determinado de páginas, ordenados por precio descendente 
 * */
