package com.jundry.colegios.controller;

import com.jundry.colegios.model.NivelGrado;
import com.jundry.colegios.model.ResumenAno;
import com.jundry.colegios.repository.NivelGradoRepository;
import com.jundry.colegios.repository.ResumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resumen")
@CrossOrigin("*")
public class ResumenAnoController {
    @Autowired
    ResumenRepository resumenRepository;

    @GetMapping("")
    public List<ResumenAno> getAllNivelGrado() {
        return resumenRepository.findAll();
    }

    @PostMapping("")
    public ResumenAno createNivelGrado(@Valid @RequestBody ResumenAno resumenAno) {
        return resumenRepository.save(resumenAno);
    }

    @GetMapping("/findAllByGradoAndAno/{grado}/{ano}")
    public List<?> getAllByGradoAndAno(@PathVariable Long grado,@PathVariable Long ano) {
        return resumenRepository.findAllByGradoAndAno(grado, ano);
    }

    @GetMapping("/findAllByGradoAndAnoAndPeriodo/{grado}/{ano}/{periodo}")
    public List<?> getAllByGradoAndAnoAndPeriodo(@PathVariable Long grado,@PathVariable Long ano, @PathVariable Long periodo) {
        return resumenRepository.findAllByGradoAndAnoAndPeriodo(grado, ano, periodo);
    }


    @GetMapping("/findAllByColegioAndGradoAndAno/{colegio}/{grado}/{ano}")
    public List<?> getAllByColegioAndGradoAndAno(@PathVariable Long colegio, @PathVariable Long grado,@PathVariable Long ano) {
        return resumenRepository.findAllByColegioAndGradoAndAno(colegio, grado, ano);
    }

    @GetMapping("/findAllByColegioAndGradoAndAnoAndPeriodo/{colegio}/{grado}/{ano}/{periodo}")
    public List<?> getAllByColegioAndGradoAndAnoAndPeriodo(@PathVariable Long colegio, @PathVariable Long grado,@PathVariable Long ano, @PathVariable Long periodo) {
        return resumenRepository.findAllByColegioAndGradoAndAnoAndPeriodo(colegio, grado, ano, periodo);
    }

}
