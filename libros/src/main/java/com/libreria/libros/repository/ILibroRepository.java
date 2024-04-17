package com.libreria.libros.repository;

import com.libreria.libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    
}
