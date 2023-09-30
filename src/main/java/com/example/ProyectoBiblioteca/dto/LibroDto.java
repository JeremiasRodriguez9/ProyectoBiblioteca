package com.example.ProyectoBiblioteca.dto;

import lombok.*;
import com.example.ProyectoBiblioteca.model.Autor;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDto {

    private String title;

    private Date publishDate;

    private String gender;

    private Set<Autor> autores;

}
