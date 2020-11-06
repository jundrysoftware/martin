package com.jundry.colegios.controller;

import com.jundry.colegios.model.Docentes;
import com.jundry.colegios.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin("*")
public class DocentesController {
    @Autowired
    DocenteRepository docenteRepository;

    @GetMapping("")
    public List<Docentes> getAllDocentes() {
        return docenteRepository.findAll();
    }

    @PostMapping("")
    public Docentes createDocentes(@Valid @RequestBody Docentes docentes) {
        return docenteRepository.save(docentes);
    }

    @GetMapping("/getAllByAno/{ano}")
    public List<?> getAllByAno(@PathVariable Long ano) {
        return docenteRepository.findAllByAno(ano);
    }

    @GetMapping("/getAllByAnoAndPeriodo/{ano}/{periodo}")
    public List<?> getAllByAno(@PathVariable Long ano, @PathVariable Long periodo) {
        return docenteRepository.findAllByAnoAndPeriodo(ano, periodo);
    }

    @GetMapping("/getAllByColegioAndAno/{colegio}/{ano}")
    public List<?> getAllByColegioAndAno(@PathVariable Long colegio,@PathVariable Long ano) {
        return docenteRepository.findAllByColegioAndAno(colegio,ano);
    }

    @GetMapping("/getAllByColegioAndAnoAndPeriodo/{colegio}/{ano}/{periodo}")
    public List<?> getAllByColegioAndAnoAndPeriodo(@PathVariable Long colegio,@PathVariable Long ano, @PathVariable Long periodo) {
        return docenteRepository.findAllByColegioAndAnoAndPeriodo(colegio,ano, periodo);
    }

}
