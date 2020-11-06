package com.jundry.colegios.controller;

import com.jundry.colegios.model.MatriculaColegio;
import com.jundry.colegios.repository.MatriculaColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/matriculaColegio")
@CrossOrigin("*")
public class MatriculaColegioController {
    @Autowired
    MatriculaColegioRepository matriculaColegioRepository;

    @GetMapping("")
    public List<MatriculaColegio> getAllMatriculaColegio() {
        return matriculaColegioRepository.findAll();
    }

    @PostMapping("")
    public MatriculaColegio createMatriculaColegio(@Valid @RequestBody MatriculaColegio matriculaColegio) {
        return matriculaColegioRepository.save(matriculaColegio);
    }

    @GetMapping("/findAllByColegioAndNivelAndAno/{colegio}/{nivel}/{ano}")
    public List<?> getAllMatriculaColegio(@PathVariable Long colegio, @PathVariable Long nivel, @PathVariable Long ano) {
        return matriculaColegioRepository.findAllByColegioAndNivelAndAno(colegio,nivel,ano);
    }

    @GetMapping("/findAllByColegioAndNivelAndAnoAndPeriodo/{colegio}/{nivel}/{ano}/{periodo}")
    public List<?> getAllMatriculaColegioTwo(@PathVariable Long colegio, @PathVariable Long nivel,@PathVariable Long ano, @PathVariable Long periodo) {
        return matriculaColegioRepository.findAllByColegioAndAnoAndPeriodo(colegio,nivel,ano,periodo);
    }
}
