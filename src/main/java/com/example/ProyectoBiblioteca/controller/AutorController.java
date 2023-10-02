package com.example.ProyectoBiblioteca.controller;

import com.example.ProyectoBiblioteca.dto.AutorDto;
import com.example.ProyectoBiblioteca.dto.LibroDto;
import com.example.ProyectoBiblioteca.service.AutorI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autores")
public class AutorController {
    private final AutorI autorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<AutorDto>> findAllAutores(){
        List<AutorDto> autores = autorService.findAllAutores();
        return new ResponseEntity<> (autores, HttpStatus.OK);
    }

    @GetMapping("/findAutor")
    public ResponseEntity<AutorDto> findAutor(@RequestParam Long id){
        AutorDto autorDto = autorService.findAutor(id);
        return new ResponseEntity<> (autorDto, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveAutor(@RequestBody AutorDto autorDto){
        String mensaje = autorService.saveAutor(autorDto);
        return  new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateAutor(@RequestBody String surname, AutorDto autorDto){
        String mensaje = autorService.updateAutor(surname,autorDto);
        return  new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteAutor(@RequestParam Long id){
        String mensaje = autorService.deleteAutor(id);
        return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
    }

}
