package com.libreria.autores.repository;

import com.libreria.autores.model.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    
    @Query(value = "SELECT a.* FROM autor a JOIN libros_por_autor l ON a.id = l.id_autor WHERE l.isbn_libro = :isbn", nativeQuery = true)
    public List<Autor> findByIsbn(Long isbn); 
    
}
