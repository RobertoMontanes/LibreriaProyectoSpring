package com.salesianostriana.dam.libreria.service;

import com.salesianostriana.dam.libreria.model.Autor;
import com.salesianostriana.dam.libreria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {
    
    @Autowired
    private AutorRepository autorRepository;
    
    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
    
    @Override
    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }
    
    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }
    
    @Override
    public Autor edit(Autor autor) {
        return autorRepository.save(autor);
    }
    
    @Override
    public void delete(Autor autor) {
        autorRepository.delete(autor);
    }
    
    @Override
    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }
    
    @Override
    public List<Autor> buscarPorNombre(String nombre) {
        return autorRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    @Override
    public List<Autor> buscarPorNacionalidad(String nacionalidad) {
        return autorRepository.findByNacionalidad(nacionalidad);
    }
    
    @Override
    public boolean tieneLibros(Long id) {
        return autorRepository.findById(id)
                .map(autor -> !autor.getLibros().isEmpty())
                .orElse(false);
    }
    
    @Override
    public List<Autor> findAutoresConLibros() {
        return autorRepository.findAutoresConLibros();
    }
}