package com.libreria.libros.model;

import com.libreria.libros.dto.AutorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ISBN;
    
    private String titulo;
    private String anioPub;
    private String descripcion;
    
    @Transient // No persiste como columna de tabla en la BD
    private List<AutorDTO> autores;
}
