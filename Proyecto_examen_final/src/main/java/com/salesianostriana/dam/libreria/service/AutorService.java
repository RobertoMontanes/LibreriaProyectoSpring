package com.salesianostriana.dam.libreria.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.libreria.model.Autor;
import com.salesianostriana.dam.libreria.repository.AutorRepository;

@Service
public class AutorService {
    
    @Autowired
    private AutorRepository autorRepository;
    
    
    public List<Autor> findByNombreContainingIgnoreCase(String nombre) {
        return autorRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    public List<Autor> findByNacionalidad(String nacionalidad) {
        return autorRepository.findByNacionalidad(nacionalidad);
    }
    
    public List<Autor> findAutoresConLibros() {
        return autorRepository.findAutoresConLibros();
    }
    
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
}
