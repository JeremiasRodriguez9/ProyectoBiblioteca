package com.example.ProyectoBiblioteca.mapper;

import com.example.ProyectoBiblioteca.dto.AutorDto;
import com.example.ProyectoBiblioteca.model.Autor;

public class MapperAutor {

    public static AutorDto toDto(Autor autor){
        AutorDto autorDto = new AutorDto();

        autorDto.setLibros(autor.getLibros());
        autorDto.setName(autor.getName());
        autorDto.setSurname(autor.getSurname());
        return autorDto;
    }

    public static Autor toEntity(AutorDto autorDto){
        Autor autor = new Autor();

        autor.setName(autorDto.getName());
        autor.setSurname(autorDto.getSurname());
        autor.setLibros(autor.getLibros());
        return autor;
    }
}
