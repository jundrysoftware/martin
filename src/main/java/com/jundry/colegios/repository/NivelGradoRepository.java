package com.jundry.colegios.repository;

import com.jundry.colegios.model.NivelGrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelGradoRepository extends JpaRepository<NivelGrado,Long> {
}
