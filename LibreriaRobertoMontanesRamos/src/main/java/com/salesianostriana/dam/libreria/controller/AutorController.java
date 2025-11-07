package com.salesianostriana.dam.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.salesianostriana.dam.libreria.model.Autor;
import com.salesianostriana.dam.libreria.service.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private AutorService autorService;
    
    // Listar todos los autores
    @GetMapping
    public String listarAutores(Model model) {
        model.addAttribute("autores", autorService.findAll());
        return "autores/lista";
    }
    
    // Mostrar formulario de nuevo autor
    @GetMapping("/nuevo")
    public String nuevoAutorForm(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/formulario";
    }
    
    // Guardar autor
    @PostMapping("/guardar")
    public String guardarAutor(@ModelAttribute Autor autor) {
        autorService.save(autor);
        return "redirect:/autores";
    }
    
    // Ver detalle de un autor
    @GetMapping("/{id}")
    public String verAutor(@PathVariable Long id, Model model) {
        model.addAttribute("autor", autorService.findById(id).orElse(null));
        return "autores/detalle";
    }
    
    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarAutorForm(@PathVariable Long id, Model model) {
        model.addAttribute("autor", autorService.findById(id).orElse(null));
        return "autores/formulario";
    }
    
    // Eliminar autor
    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Long id) {
        autorService.deleteById(id);
        return "redirect:/autores";
    }
}