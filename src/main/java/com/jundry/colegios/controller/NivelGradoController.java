package com.jundry.colegios.controller;

import com.jundry.colegios.exception.ResourceNotFoundException;
import com.jundry.colegios.model.NivelGrado;
import com.jundry.colegios.repository.NivelGradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/nivelGrado")
@CrossOrigin("*")
public class NivelGradoController {
    @Autowired
    NivelGradoRepository nivelGradoRepository;

    @GetMapping("")
    public List<NivelGrado> getAllNivelGrado() {
        return nivelGradoRepository.findAll();
    }

    @PostMapping("")
    public NivelGrado createNivelGrado(@Valid @RequestBody NivelGrado nivelGrado) {
        return nivelGradoRepository.save(nivelGrado);
    }

    @GetMapping("/{id}")
    public NivelGrado getNivelGradoById(@PathVariable(value = "id") Long nivelGradoId) {
        return nivelGradoRepository.findById(nivelGradoId)
                .orElseThrow(() -> new ResourceNotFoundException("NivelGrado", "id", nivelGradoId));
    }
}
