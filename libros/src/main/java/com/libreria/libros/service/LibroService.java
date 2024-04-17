package com.libreria.libros.service;

import com.libreria.libros.model.Libro;
import com.libreria.libros.repository.ILibroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService implements ILibroService{
    
    @Autowired
    private ILibroRepository libroRepo;

    @Override
    public void createLibro(Libro libro) {
        libroRepo.save(libro);
    }

    @Override
    public List<Libro> getLibros() {
        return libroRepo.findAll();
    }

    @Override
    public Libro getLibroByIsbn(Long isbn) {
        return libroRepo.findById(isbn).orElse(null);
    }
}
