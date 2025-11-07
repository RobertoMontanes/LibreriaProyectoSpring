package com.salesianostriana.dam.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.libreria.service.*;

@Controller
public class MainController {
    
    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalLibros", libroService.findAll().size());
        model.addAttribute("totalAutores", autorService.findAll().size());
        model.addAttribute("totalCategorias", categoriaService.findAll().size());
        return "index";
    }
}