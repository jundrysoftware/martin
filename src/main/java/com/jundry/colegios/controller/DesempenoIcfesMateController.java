package com.jundry.colegios.controller;

import com.jundry.colegios.model.DesempenoIcfesCol;
import com.jundry.colegios.model.DesempenoIcfesMate;
import com.jundry.colegios.repository.DesempenoIcfesMateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/desempenoIcfesMate")
@CrossOrigin("*")
public class DesempenoIcfesMateController {
    @Autowired
    DesempenoIcfesMateRepository desempenoIcfesMateRepository;

    @GetMapping("")
    public List<DesempenoIcfesMate> getAllDesempenoIcfesMatel() {
        return desempenoIcfesMateRepository.findAll();
    }

    @PostMapping("")
    public DesempenoIcfesMate createDesempenoIcfesMate(@Valid @RequestBody DesempenoIcfesMate desempenoIcfesMate) {
        return desempenoIcfesMateRepository.save(desempenoIcfesMate);
    }

    @GetMapping("/findAllByColegioAndMateriaAndAno/{colegio}/{materia}/{ano}")
    public List<DesempenoIcfesMate> getAllDesempenoIcfesMatel(@PathVariable Long colegio,@PathVariable Long materia, @PathVariable Long ano) {
        return desempenoIcfesMateRepository.findAllByColegioAndMateriaAndAno(colegio,materia,ano);
    }

    @GetMapping("/findAllByMateriaAndAno/{materia}/{ano}")
    public List<DesempenoIcfesMate> getAllDesempenoIcfesMatel(@PathVariable Long materia, @PathVariable Long ano) {
        return desempenoIcfesMateRepository.findAllByMateriaAndAno(materia,ano);
    }
}
