package com.libreria.autores.service;

import com.libreria.autores.model.Autor;
import com.libreria.autores.repository.IAutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IAutorService {
    
    @Autowired
    private IAutorRepository autorRepo;
    
    @Override
    public void createAutor(Autor autor) {
        autorRepo.save(autor);
    }

    @Override
    public List<Autor> getAutores() {
        return autorRepo.findAll();
    }

    @Override
    public Autor getAutorById(Long id) {
        return autorRepo.findById(id).orElse(null);
    }
}
