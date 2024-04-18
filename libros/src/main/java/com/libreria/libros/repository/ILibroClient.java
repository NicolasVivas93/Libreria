package com.libreria.libros.repository;

import com.libreria.libros.dto.AutorDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "autorapi", url = "http://localhost:9001/autor/traerPorIsbn")
public interface ILibroClient {
    
    @GetMapping("/{isbn}")
    public List<AutorDTO> getAutorInfo(@PathVariable("isbn") Long isbn);
}
