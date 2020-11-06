package com.jundry.colegios.controller;

import com.jundry.colegios.exception.ResourceNotFoundException;
import com.jundry.colegios.model.Colegios;
import com.jundry.colegios.repository.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ColegioController {
    @Autowired
    ColegioRepository colegioRepository;

    @GetMapping("/colegio")
    public List<Colegios> getAllColegios() {
        return colegioRepository.findAll();
    }

    @PostMapping("/colegio")
    public Colegios createColegios(@Valid @RequestBody Colegios colegios) {
        return colegioRepository.save(colegios);
    }

    @PutMapping("/colegio/{id}")
    public Colegios updateColegios(@PathVariable(value = "id") Long colegioId,
                           @Valid @RequestBody Colegios colegioDetails) {

        Colegios colegio = colegioRepository.findById(colegioId)
                .orElseThrow(() -> new ResourceNotFoundException("colegio", "id", colegioId));
    
        colegio.setCod(colegioDetails.getCod());
        colegio.setNit(colegioDetails.getNit());
        colegio.setName(colegioDetails.getName());
        colegio.setNivel(colegioDetails.getNivel());
        Colegios updatedColegios = colegioRepository.save(colegio);
        return updatedColegios;
    }
}
