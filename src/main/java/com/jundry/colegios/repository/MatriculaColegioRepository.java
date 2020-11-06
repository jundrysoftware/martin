package com.jundry.colegios.repository;

import com.jundry.colegios.model.MatriculaColegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaColegioRepository extends JpaRepository<MatriculaColegio, Long> {
    @Query(value = "select c.name as colegio, n.nivel as nivel, SUM(mc.mat_cant_alum) as cantidad, SUM(mc.mat_extraedad) as extraedad from matricula_colegio mc " +
            "join colegio c on mc.colegio_id = c.id " +
            "join nivel_grado n on mc.nivel_id = n.id " +
            "where mc.colegio_id = :colegioId and mc.nivel_id= :nivelId and mc.mat_actual_ano = :ano and mc.mat_periodo = :periodo GROUP By mc.nivel_id order by mc.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndAnoAndPeriodo(Long colegioId, Long nivelId, Long ano, Long periodo);

    @Query(value = "select c.name as colegio, n.nivel as nivel, SUM(mc.mat_cant_alum) as cantidad, SUM(mc.mat_extraedad) as extraedad from matricula_colegio mc " +
            "join colegio c on mc.colegio_id = c.id " +
            "join nivel_grado n on mc.nivel_id = n.id " +
            "where mc.colegio_id = :colegioId and mc.nivel_id = :nivelId and mc.mat_actual_ano = :ano and mc.mat_periodo IN ('1', '2', '3','4') GROUP By mc.nivel_id order by mc.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndNivelAndAno(Long colegioId, Long nivelId,Long ano);
}
