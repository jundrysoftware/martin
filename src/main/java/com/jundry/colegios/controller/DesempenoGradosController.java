package com.jundry.colegios.controller;

import com.jundry.colegios.model.DesempenoGrados;
import com.jundry.colegios.repository.DesempenoGradosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/desempenoGrados")
@CrossOrigin("*")
public class DesempenoGradosController {
    @Autowired
    DesempenoGradosRepository desempenoGradosRepository;

    @GetMapping("")
    public List<DesempenoGrados> getAllDesempenoGrados() {
        return desempenoGradosRepository.findAll();
    }

    @PostMapping("")
    public DesempenoGrados createDesempenoGrados(@Valid @RequestBody DesempenoGrados desempeno) {
        return desempenoGradosRepository.save(desempeno);
    }

    //Filtro por colegio

    @GetMapping("/getAllByColegioAndMateriaAndAnoAndGrado/{colegio}/{materia}/{ano}/{grado}")
    public List<?> getAllByColegioAndMateriaAndAnoAndGrado(@PathVariable Long colegio, @PathVariable Long materia, @PathVariable Long ano, @PathVariable Long grado) {
        return desempenoGradosRepository.findAllByColegioAndDesActualAnoAndDesNivel(colegio, materia, ano, grado);
    }

    @GetMapping("/getAllByColegioAndMateriaAndAnoAndGradoAndPeriodo/{colegio}/{materia}/{ano}/{grado}/{periodo}")
    public List<?> getAllByColegioAndMateriaAndAnoAndGradoAndPeriodo(@PathVariable Long colegio, @PathVariable Long materia, @PathVariable Long ano, @PathVariable Long grado, @PathVariable Long periodo) {
        return desempenoGradosRepository.findAllByColegioAndMateriaAndAnoAndGradoAndPeriodo(colegio, materia, ano, grado, periodo);
    }

    @GetMapping("/getAllByMateriaAndAnoAndGrado/{materia}/{ano}/{grado}")
    public List<?> getAllByMateriaAndAnoAndGrado(@PathVariable Long materia, @PathVariable Long ano, @PathVariable Long grado) {
        return desempenoGradosRepository.findAllByDesActualAnoAndDesNivel(materia, ano, grado);
    }

    @GetMapping("/getAllByMateriaAndAnoAndGradoAndPeriodo/{materia}/{ano}/{grado}/{periodo}")
    public List<?> getAllByMateriaAndAnoAndGradoAndPeriodo(@PathVariable Long materia, @PathVariable Long ano, @PathVariable Long grado, @PathVariable Long periodo) {
        return desempenoGradosRepository.findAllByateriaAndAnoAndGradoAndPeriodo(materia, ano, grado, periodo);
    }

}
