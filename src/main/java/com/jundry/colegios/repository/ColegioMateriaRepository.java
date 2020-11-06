package com.jundry.colegios.repository;

import com.jundry.colegios.model.ColegioMateria;
import com.jundry.colegios.model.Colegios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColegioMateriaRepository extends JpaRepository<ColegioMateria,Long> {
    List<ColegioMateria> findAllByColegio(Colegios colegios);
}
