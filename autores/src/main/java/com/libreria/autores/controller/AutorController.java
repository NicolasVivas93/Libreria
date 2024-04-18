package com.libreria.autores.controller;

import com.libreria.autores.model.Autor;
import com.libreria.autores.service.IAutorService;
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
@RequestMapping("/autor")
public class AutorController {
    
    @Autowired
    private IAutorService autorServ;
    
    @PostMapping("/crear")
    public void createAutor(@RequestBody Autor autor) {
        autorServ.createAutor(autor);
    }
    
    @GetMapping("/traer")
    @ResponseBody
    public List<Autor> getAutores() {
        return autorServ.getAutores();
    }
    
    @GetMapping("/traerById/{idAutor}")
    @ResponseBody
    public Autor getAutorById(@PathVariable ("idAutor") Long idAutor) {
        return autorServ.getAutorById(idAutor);
    }
    
    @GetMapping("/traerPorIsbn/{isbn}")
    public List<Autor> getAutoresByIsbn(@PathVariable Long isbn) {
        return autorServ.getAutoresByIsbn(isbn);
    }
    
}
