package com.salesianostriana.dam.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.salesianostriana.dam.libreria.model.Categoria;
import com.salesianostriana.dam.libreria.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    // Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categorias/lista";
    }
    
    // Mostrar formulario de nueva categoría
    @GetMapping("/nueva")
    public String nuevaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }
    
    // Guardar categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }
    
    // Ver detalle de una categoría
    @GetMapping("/{id}")
    public String verCategoria(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.findById(id).orElse(null));
        return "categorias/detalle";
    }
    
    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarCategoriaForm(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaService.findById(id).orElse(null));
        return "categorias/formulario";
    }
    
    // Eliminar categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return "redirect:/categorias";
    }
}