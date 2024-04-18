package com.libreria.autores.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNac;
    
    private String nacionalidad;
    
    @ElementCollection
    @CollectionTable(name = "libros_por_autor", joinColumns = @JoinColumn(name = "id_autor"))
    private List<Long> isbnLibro; // Lista de libros por su ISBN
}
