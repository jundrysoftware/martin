package com.jundry.colegios.controller;

import com.jundry.colegios.model.Colegios;
import com.jundry.colegios.model.DesempenoGlobal;
import com.jundry.colegios.model.DesempenoGlobalUtil;
import com.jundry.colegios.model.Materia;
import com.jundry.colegios.repository.DesempenoGlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/desempenoGlobal")
@CrossOrigin("*")
public class DesempenoGlobalController {
    @Autowired
    DesempenoGlobalRepository desempenoGlobalRepository;

    @GetMapping("")
    public List<DesempenoGlobal> getAllDesempenoGlobal() {
        return desempenoGlobalRepository.findAll();
    }

    @PostMapping("")
    public DesempenoGlobal createDesempenoGlobal(@Valid @RequestBody DesempenoGlobal colegios) {
        return desempenoGlobalRepository.save(colegios);
    }

    //Filtro por colegio

    @GetMapping("/getAllByColegioAndAno/{colegio}/{materia}/{ano}")
    public List<?> getAllByColegioAndAno(@PathVariable Long colegio, @PathVariable Long materia, @PathVariable Long ano) {
        return desempenoGlobalRepository.findAllByColegioAndMateriaAndDesActualAno(colegio,materia, ano);
    }

    @GetMapping("/getAllByColegioAndAnoAndPeriodo/{colegio}/{materia}/{ano}/{periodo}")
    public List<?> getAllByColegioAndAnoAndPeriodo(@PathVariable Long colegio, @PathVariable Long materia, @PathVariable Long ano, @PathVariable Long periodo) {
        return desempenoGlobalRepository.findAllByColegioAndMateriaAndDesActualAnoAndPeriodo(colegio, materia, ano, periodo);
    }


    //UTIL


    @GetMapping("/getAllByNotColegio/{materia}/{ano}/{periodo}")
    public List<?> getAllByUtilTwo(@PathVariable Long materia, @PathVariable Long ano, @PathVariable Long periodo) {
        return desempenoGlobalRepository.findAllByUtilTwo(materia, ano,periodo);
    }

    @GetMapping("/getAllByUtil/{materia}/{ano}")
    public List<?> getAllByUtil(@PathVariable Long materia, @PathVariable Long ano) {
        return desempenoGlobalRepository.findAllByUtil(materia, ano);
    }


}
