package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.model.Libro;
import com.example.ProyectoBiblioteca.service.LibroI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {

    private final LibroI libroService;
    @GetMapping("/findAll")
    public ResponseEntity<List<LibroDto>> findAllLibros(){
        List<LibroDto> lista =  libroService.findAllLibros();
        return new ResponseEntity<> (lista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveLibros(@RequestBody LibroDto librodto){
        String mensaje = libroService.saveLibro(librodto);
        return  new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping("/findLibro")
    public ResponseEntity<LibroDto> findLibro(@RequestParam String title){
        LibroDto libroDto = libroService.findLibro(title);
        return new ResponseEntity<>(libroDto, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateLibro(@RequestBody Long id, LibroDto librodto){
        String mensaje = libroService.updateLibro(id,librodto);
        return  new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteLibro(@RequestParam Long id){
        String mensaje = libroService.deleteLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
