package com.example.arqui.NotasService.service;

import com.example.arqui.NotasService.model.Nota;
import com.example.arqui.NotasService.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    @Autowired
    public NotaRepository notaRepository;
    public Nota guardar(Nota nota){
       return notaRepository.save(nota);
    }

    public List<Nota> getAll() {
        return notaRepository.findAll();
    }

    public Optional<Nota> obtenerporId(Integer id) {
        return notaRepository.findById(id);
    }

    public Nota getCurso(Integer id) {
        return notaRepository.findById(id).get();
    }

    public void eliminar(Integer id) {
        notaRepository.deleteById(id);
    }
}
