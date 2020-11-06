package com.jundry.colegios.controller;

import com.jundry.colegios.exception.ResourceNotFoundException;
import com.jundry.colegios.model.MatriculaColegio;
import com.jundry.colegios.model.NivelColegio;
import com.jundry.colegios.model.NivelGrado;
import com.jundry.colegios.repository.NivelColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/nivelColegio")
@CrossOrigin("*")
public class NivelColegioController {
    @Autowired
    NivelColegioRepository nivelColegioRepository;

    @GetMapping("")
    public List<NivelColegio> getAllNivelColegio() {
        return nivelColegioRepository.findAll();
    }

    @PostMapping("")
    public NivelColegio createNivelColegio(@Valid @RequestBody NivelColegio nivelColegio) {
        return nivelColegioRepository.save(nivelColegio);
    }
    @GetMapping("/{id}")
    public NivelColegio getNivelColegioById(@PathVariable(value = "id") Long nivelColegioId) {
        return nivelColegioRepository.findById(nivelColegioId)
                .orElseThrow(() -> new ResourceNotFoundException("Nivel Colegio", "id", nivelColegioId));
    }

}
