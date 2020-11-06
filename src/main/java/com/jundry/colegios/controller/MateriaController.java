package com.jundry.colegios.controller;

import com.jundry.colegios.exception.ResourceNotFoundException;
import com.jundry.colegios.model.Colegios;
import com.jundry.colegios.model.Materia;
import com.jundry.colegios.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MateriaController {
    @Autowired
    MateriaRepository materiaRepository;

    @GetMapping("/materia")
    public List<Materia> getAllMateria() {
        return materiaRepository.findAll();
    }

    @PostMapping("/materia")
    public Materia createMateria(@Valid @RequestBody Materia materia) {
        return materiaRepository.save(materia);
    }

    @PutMapping("/materia/{id}")
    public Materia updateMateria(@PathVariable(value = "id") Long materiaId,
                                   @Valid @RequestBody Materia materiaDetails) {

        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new ResourceNotFoundException("materia", "id", materiaId));

        materia.setMateria(materiaDetails.getMateria());
        Materia updatedMateria = materiaRepository.save(materia);
        return updatedMateria;
    }
}
