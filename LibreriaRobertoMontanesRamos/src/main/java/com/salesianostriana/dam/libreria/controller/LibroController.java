package com.salesianostriana.dam.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.salesianostriana.dam.libreria.model.Libro;
import com.salesianostriana.dam.libreria.service.*;

@Controller
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    
    @Autowired
    private AutorService autorService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    // Listar todos los libros
    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.findAll());
        return "libros/lista";
    }
    
    // Mostrar formulario de nuevo libro
    @GetMapping("/nuevo")
    public String nuevoLibroForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("autores", autorService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "libros/formulario";
    }
    
    // Guardar libro (crear o editar)
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.save(libro);
        return "redirect:/libros";
    }
    
    // Ver detalle de un libro
    @GetMapping("/{id}")
    public String verLibro(@PathVariable Long id, Model model) {
        model.addAttribute("libro", libroService.findById(id).orElse(null));
        return "libros/detalle";
    }
    
    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarLibroForm(@PathVariable Long id, Model model) {
        model.addAttribute("libro", libroService.findById(id).orElse(null));
        model.addAttribute("autores", autorService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "libros/formulario";
    }
    
    // Eliminar libro
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.deleteById(id);
        return "redirect:/libros";
    }
    
    // Búsqueda por título
    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam(required = false) String titulo, Model model) {
        if (titulo != null && !titulo.isEmpty()) {
            model.addAttribute("libros", libroService.buscarPorTitulo(titulo));
        } else {
            model.addAttribute("libros", libroService.findAll());
        }
        model.addAttribute("busqueda", titulo);
        return "libros/lista";
    }
}