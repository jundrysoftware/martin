package com.jundry.colegios.controller;

import com.jundry.colegios.model.ColegioMateria;
import com.jundry.colegios.model.Colegios;
import com.jundry.colegios.repository.ColegioMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ColegioMateriaController {
    @Autowired
    ColegioMateriaRepository colegioMateriaRepository;

    @GetMapping("/colegioMateria")
    public List<ColegioMateria> getAllColegioMateria() {
        return colegioMateriaRepository.findAll();
    }

    @PostMapping("/colegioMateria")
    public ColegioMateria createColegioMateria(@Valid @RequestBody ColegioMateria colegios) {
        return colegioMateriaRepository.save(colegios);
    }

    @PostMapping("/colegioMateriaBycolegio")
    public List<ColegioMateria> createColegioMateriaByColegio(@Valid @RequestBody Colegios colegio) {
        List<ColegioMateria> colegios = colegioMateriaRepository.findAllByColegio(colegio);
        return colegios;
    }
}
