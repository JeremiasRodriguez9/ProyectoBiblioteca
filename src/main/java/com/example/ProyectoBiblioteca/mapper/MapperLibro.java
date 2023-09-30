package com.example.ProyectoBiblioteca.mapper;

import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.model.Libro;

public class MapperLibro {

    public static LibroDto toDto(Libro libro){

        LibroDto libroDto = new LibroDto();

        libroDto.setTitle(libro.getTitle());
        libroDto.setPublishDate(libro.getPublishDate());
        libroDto.setGender(libro.getGender());
        libroDto.setAutores(libro.getAutores());
        return libroDto;
    }

    public static Libro toEntity(LibroDto libroDto){
        Libro libro = new Libro();
        libro.setTitle(libroDto.getTitle());
        libro.setPublishDate(libroDto.getPublishDate());
        libro.setGender(libroDto.getGender());
        libro.setAutores(libroDto.getAutores());

        return libro;
    }
}
