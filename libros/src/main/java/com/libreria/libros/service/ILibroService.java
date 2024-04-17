package com.libreria.libros.service;

import com.libreria.libros.model.Libro;
import java.util.List;

public interface ILibroService {
    
    public void createLibro(Libro libro);
    
    public List<Libro> getLibros();
    public Libro getLibroByIsbn(Long isbn);
}
