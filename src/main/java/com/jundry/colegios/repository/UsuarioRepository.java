package com.jundry.colegios.repository;

import com.jundry.colegios.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    Usuarios findByEmail(String email);
}
