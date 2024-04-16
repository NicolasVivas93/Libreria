package com.libreria.autores.service;

import com.libreria.autores.model.Autor;
import java.util.List;

public interface IAutorService {
    
    public void createAutor(Autor autor);
    
    public List<Autor> getAutores();
    public Autor getAutorById(Long id);
}
