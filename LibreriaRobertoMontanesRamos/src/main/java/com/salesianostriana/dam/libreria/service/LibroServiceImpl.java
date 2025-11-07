package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Libro;
import com.salesianostriana.dam.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
    
    @Override
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }
    
    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
    
    @Override
    public Libro edit(Libro libro) {
        return libroRepository.save(libro);
    }
    
    @Override
    public void delete(Libro libro) {
        libroRepository.delete(libro);
    }
    
    @Override
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
    
    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }
    
    @Override
    public List<Libro> buscarPorPrecioBetween(Double min, Double max) {
        return libroRepository.findByPrecioBetween(min, max);
    }
    
    @Override
    public List<Libro> buscarPorAutorNombre(String nombreAutor) {
        return libroRepository.findByAutorNombreContainingIgnoreCase(nombreAutor);
    }
    
    @Override
    public List<Libro> buscarPorCategoriaNombre(String categoriaNombre) {
        return libroRepository.findByCategoriaNombre(categoriaNombre);
    }
    
    @Override
    public List<Libro> findLibrosConMasPaginasQue(int paginas) {
        return libroRepository.findLibrosConMasPaginasQue(paginas);
    }
    
    @Override
    public List<Libro> findAllOrderByPrecioDesc() {
        return libroRepository.findAllByOrderByPrecioDesc();
    }
    
    @Override
    public List<Libro> findAllOrderByTituloAsc() {
        return libroRepository.findAllByOrderByTituloAsc();
    }
}