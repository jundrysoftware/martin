package com.jundry.colegios.repository;

import com.jundry.colegios.model.NivelColegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelColegioRepository extends JpaRepository<NivelColegio,Long> {
}
