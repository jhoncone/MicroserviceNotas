package com.example.arqui.NotasService.controller;

import com.example.arqui.NotasService.model.Nota;
import com.example.arqui.NotasService.service.NotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotaController {

    @Autowired
    public NotaService notaService;


    @PostMapping("/agregar")
    public  ResponseEntity<?> guardar(@RequestBody Nota nota){
        notaService.guardar(nota);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getcursos",produces = "application/json")
    public List<Nota>  listaNotas(){
        List<Nota> listaCursos = notaService.getAll();
        return listaCursos;
    }

    @GetMapping(path = "/curso/{id}")
    public Optional<Nota> getNotaById(@PathVariable("id") Integer id){
        return notaService.obtenerporId(id);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@RequestBody Nota nota, @PathVariable Integer id) {
        try {
            Nota nota1 = notaService.getCurso(id);
            nota.setId(id);
            notaService.guardar(nota);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<?> eliminarCurso(@PathVariable("id") Integer id, Model modelo){
        notaService.eliminar(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
