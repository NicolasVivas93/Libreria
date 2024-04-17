package com.libreria.libros.controller;

import com.libreria.libros.model.Libro;
import com.libreria.libros.service.ILibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libro")
public class LibroController {
    
    @Autowired
    private ILibroService libroServ;
    
    @PostMapping("/crear")
    public String createLibro(@RequestBody Libro libro) {
        libroServ.createLibro(libro);
        return "Libro creado";
    }
    
    @GetMapping("/traer")
    @ResponseBody
    public List<Libro> getLibros() {
        return libroServ.getLibros();
    }
    
    @GetMapping("/traerPorIsbn/{isbn}")
    @ResponseBody
    public Libro getLibroByIsbn(@PathVariable Long isbn) {
        return libroServ.getLibroByIsbn(isbn);
    }
}
