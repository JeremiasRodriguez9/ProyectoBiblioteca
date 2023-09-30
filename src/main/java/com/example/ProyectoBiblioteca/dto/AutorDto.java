package com.example.ProyectoBiblioteca.dto;


import lombok.*;
import com.example.ProyectoBiblioteca.model.Libro;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorDto {

    private String name;

    private String surname;

    private Set<Libro> libros;

}
