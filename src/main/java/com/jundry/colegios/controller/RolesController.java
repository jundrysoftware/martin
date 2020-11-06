package com.jundry.colegios.controller;

import com.jundry.colegios.exception.ResourceNotFoundException;
import com.jundry.colegios.model.Colegios;
import com.jundry.colegios.model.Materia;
import com.jundry.colegios.model.ResumenAno;
import com.jundry.colegios.model.Roles;
import com.jundry.colegios.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RolesController {
    @Autowired
    RolesRepository rolesRepository;

    @GetMapping("/roles")
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @PostMapping("/roles")
    public Roles createRoles(@Valid @RequestBody Roles roles) {
        return rolesRepository.save(roles);
    }

    @PutMapping("/Roles/{id}")
    public Roles updateRoles(@PathVariable(value = "id") Long rolesId,
                                 @Valid @RequestBody Roles rolesDetails) {

        Roles roles = rolesRepository.findById(rolesId)
                .orElseThrow(() -> new ResourceNotFoundException("roles", "id", rolesId));

        roles.setRol(rolesDetails.getRol());
        Roles updatedRoles = rolesRepository.save(roles);
        return updatedRoles;
    }
}
