package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.dto.AutorDto;
import com.example.ProyectoBiblioteca.mapper.MapperAutor;
import com.example.ProyectoBiblioteca.model.Autor;
import com.example.ProyectoBiblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorImpl implements AutorI {

    private final AutorRepository autorRepository;

    @Override
    public List<AutorDto> findAllAutores() {
        List<AutorDto> listaAutores = autorRepository.findAll().stream()
                .map(MapperAutor::toDto)
                .collect(Collectors.toList());
        return listaAutores;
    }

    @Override
    public AutorDto findAutor(String surename) {
        Autor autorEntity = autorRepository.findBySurname(surename);
        AutorDto autorDto = MapperAutor.toDto(autorEntity);
        return autorDto;
    }

    @Override
    public String saveAutor(AutorDto autorDto) {
        Autor autorEntity = MapperAutor.toEntity(autorDto);
        autorRepository.save(autorEntity);
        return "Autor guardado exitosamente";
    }

    @Override
    public String updateAutor(String surname, AutorDto autorDto) {
        Autor autor = autorRepository.findBySurname(surname);

        autor.setName(autorDto.getName());
        autor.setSurname(autorDto.getSurname());
        autor.setLibros(autorDto.getLibros());
        autorRepository.save(autor);
        return "el autor: " + autor.getName() + " " + autor.getSurname() + " actualizado exitosamente";
    }

    @Override
    public String deleteAutor(Long id) {
        autorRepository.deleteById(id);
        return "el autor" + id + "eliminado exitosamente";
    }
}
