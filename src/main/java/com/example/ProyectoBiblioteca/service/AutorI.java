package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.dto.AutorDto;

import java.util.List;

public interface AutorI {

    List<AutorDto> findAllAutores();

    AutorDto findAutor(Long id);

    String saveAutor(AutorDto autorDto);

    String updateAutor(String surname, AutorDto autorDto);

    String deleteAutor(Long id);
}
