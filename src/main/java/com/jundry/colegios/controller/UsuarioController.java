package com.jundry.colegios.controller;

import com.jundry.colegios.exception.ResourceNotFoundException;
import com.jundry.colegios.model.NivelColegio;
import com.jundry.colegios.model.NivelGrado;
import com.jundry.colegios.model.Roles;
import com.jundry.colegios.model.Usuarios;
import com.jundry.colegios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public List<Usuarios> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("")
    public Usuarios createUsuarios(@Valid @RequestBody Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }

    @PostMapping("/findUser")
    public Usuarios FindByUser(@RequestBody Map<String, Object> object) throws Exception {
        try {
            Iterator it = object.keySet().iterator();
            String email="";
            if(it.hasNext()){
                String key = (String) it.next();
                if(key.equalsIgnoreCase("email")){
                    email=object.get(key).toString();
                }
            }
            Usuarios usuario=  usuarioRepository.findByEmail(email);
            return  usuario;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Usuarios updateUsuarios(@PathVariable(value = "id") Long usuarioId,
                             @Valid @RequestBody Usuarios usuarioDetails) {

        Usuarios usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("usuario", "id", usuarioId));

        usuario.setRol(usuarioDetails.getRol());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setLastname(usuarioDetails.getLastname());
        usuario.setName(usuarioDetails.getName());

        Usuarios updatedUsuarios = usuarioRepository.save(usuario);
        return updatedUsuarios;
    }
}
