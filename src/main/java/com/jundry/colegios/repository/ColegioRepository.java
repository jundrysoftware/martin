package com.jundry.colegios.repository;

import com.jundry.colegios.model.Colegios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegioRepository extends JpaRepository<Colegios,Long> {
}
