package com.jundry.colegios.controller;
import com.jundry.colegios.model.Colegios;
import com.jundry.colegios.model.DesempenoIcfesCol;
import com.jundry.colegios.repository.DesempenoIcfesColRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/desempenoIcfesCol")
@CrossOrigin("*")
public class DesempenoIcfesColController {
    @Autowired
    DesempenoIcfesColRepository desempenoIcfesColRepository;

    @GetMapping("")
    public List<DesempenoIcfesCol> getAllDesempenoIcfesCol() {
        return desempenoIcfesColRepository.findAll();
    }

    @PostMapping("")
    public DesempenoIcfesCol createDesempenoIcfesCol(@Valid @RequestBody DesempenoIcfesCol desempenoIcfesCol) {
        return desempenoIcfesColRepository.save(desempenoIcfesCol);
    }

    @GetMapping("/findAllByColegioAndDesActualAno/{colegio}/{ano}")
    public List<DesempenoIcfesCol> getAllByColegioAndAno(@PathVariable Long colegio,@PathVariable Long ano) {
        return desempenoIcfesColRepository.findAllByColegioAndDesActualAno(colegio, ano);
    }

    @GetMapping("/findAllByAno/{ano}")
    public List<DesempenoIcfesCol> getAllByAno(@PathVariable Long ano) {
        return desempenoIcfesColRepository.findAllByAno(ano);
    }
}
