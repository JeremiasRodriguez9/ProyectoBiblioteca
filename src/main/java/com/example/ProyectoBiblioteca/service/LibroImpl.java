package com.example.ProyectoBiblioteca.service;

import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.mapper.MapperLibro;
import com.example.ProyectoBiblioteca.model.Libro;
import com.example.ProyectoBiblioteca.repository.LibroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroImpl implements LibroI{

    private final LibroRepository libroRepository;
    @Override
    public List<LibroDto> findAllLibros() {
        List<LibroDto> listaLibros =   libroRepository.findAll().stream()
                .map(MapperLibro::toDto)
                .collect(Collectors.toList());
        return listaLibros;
    }

    @Override
    public String saveLibro(LibroDto libroDto) {
        Libro libroEntity = MapperLibro.toEntity(libroDto);
        libroRepository.save(libroEntity);
        return "Libro guardado exitosamente";
    }

    @Override
    public LibroDto findLibro(String title) {
       Libro libroEntity = libroRepository.findByTitle(title);
       LibroDto libroDto = MapperLibro.toDto(libroEntity);
       return libroDto;
    }

    @Override
    public String updateLibro(Long id, LibroDto libroDto) {
        Libro libro = libroRepository.findById(id).orElseThrow();

        libro.setTitle(libroDto.getTitle());
        libro.setGender(libroDto.getGender());
        libro.setAutores(libroDto.getAutores());
        libro.setPublishDate(libroDto.getPublishDate());

        libroRepository.save(libro);
        return "Libro " + libro.getTitle() + " Actualizado Correctamente";
    }

    @Override
    public String deleteLibro(Long id) {
        libroRepository.deleteById(id);
        return "El libro: " + id + " fue eliminado";
    }
}
