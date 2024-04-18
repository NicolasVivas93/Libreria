package com.libreria.libros.controller;

import com.libreria.libros.dto.AutorDTO;
import com.libreria.libros.model.Libro;
import com.libreria.libros.repository.ILibroClient;
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
    
    @Autowired
    private ILibroClient libroClient;
    
    private List<AutorDTO> listAutores;
    
    @PostMapping("/crear")
    public @ResponseBody Libro createLibro(@RequestBody Libro libro) {
        libroServ.createLibro(libro);
        
        Long isbn = libro.getISBN();
        Libro libroCompleto = this.getLibroByIsbn(isbn);
        listAutores = this.getAutorInfo(isbn);
        libroCompleto.setAutores(listAutores);
        
        return libroCompleto;
    }
    
    // Autores viene nulo, consumir el servicio acá también
    @GetMapping("/traer")
    @ResponseBody
    public List<Libro> getLibros() {
        List<Libro> listaLibros = libroServ.getLibros();
         
        
        for(Libro libro : listaLibros ) {
            listAutores = this.getAutorInfo(libro.getISBN());
            libro.setAutores(listAutores);
        }
        
        return listaLibros;
    }
    
    @GetMapping("/traerPorIsbn/{isbn}")
    @ResponseBody
    public Libro getLibroByIsbn(@PathVariable Long isbn) {
        Libro libro = libroServ.getLibroByIsbn(isbn);
        listAutores = this.getAutorInfo(isbn);
        libro.setAutores(listAutores);
        return libro;
    }
    
    @GetMapping("/traerAutor/{isbn}")
    public List<AutorDTO> getAutorInfo(@PathVariable("isbn") Long isbn) {
        return libroClient.getAutorInfo(isbn);
    }
    
}
