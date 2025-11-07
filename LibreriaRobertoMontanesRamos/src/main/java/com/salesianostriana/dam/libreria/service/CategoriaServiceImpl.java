package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Categoria;
import com.salesianostriana.dam.libreria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    
    @Override
    public Optional<Categoria> findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
    
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @Override
    public Categoria edit(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @Override
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
    
    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}