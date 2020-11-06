package com.jundry.colegios.repository;

import com.jundry.colegios.model.ResumenAno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumenRepository extends JpaRepository<ResumenAno,Long> {
    @Query(value = "select c.name as colegio, SUM(cant_aprobados) as aprobados, SUM(cant_desertados) as desertados, SUM(cant_repitentes) as repitentes, SUM(cant_reprobados) as reprobados, SUM(tasa_asistencia) as asistencia, SUM(tasa_de_cobertura) as cobertura, SUM(alumnos_docentes) as alumnosDocentes, SUM(internet_access) as internet, SUM(computadores_alumnos) as computadores  from resumen_ano r " +
            "join colegio c on r.colegio_id = c.id " +
            "where r.nivel_id = :gradoId and r.res_ano = :ano group by r.colegio_id order by r.id desc ", nativeQuery = true)
    List<?> findAllByGradoAndAno(Long gradoId, Long ano);

    @Query(value = "select c.name as colegio, SUM(cant_aprobados) as aprobados, SUM(cant_desertados) as desertados, SUM(cant_repitentes) as repitentes, SUM(cant_reprobados) as reprobados, SUM(tasa_asistencia) as asistencia, SUM(tasa_de_cobertura) as cobertura, SUM(alumnos_docentes) as alumnosDocentes, SUM(internet_access) as internet, SUM(computadores_alumnos) as computadores  from resumen_ano r " +
            "join colegio c on r.colegio_id = c.id " +
            "where r.nivel_id = :gradoId and r.res_ano = :ano and r.res_periodo= :periodo group by r.colegio_id order by r.id desc ", nativeQuery = true)
    List<?> findAllByGradoAndAnoAndPeriodo(Long gradoId, Long ano, Long periodo);

    @Query(value = "select c.name as colegio, SUM(cant_aprobados) as aprobados, SUM(cant_desertados) as desertados, SUM(cant_repitentes) as repitentes, SUM(cant_reprobados) as reprobados, SUM(tasa_asistencia) as asistencia, SUM(tasa_de_cobertura) as cobertura, SUM(alumnos_docentes) as alumnosDocentes, SUM(internet_access) as internet, SUM(computadores_alumnos) as computadores  from resumen_ano r " +
            "join colegio c on r.colegio_id = c.id " +
            "where r.colegio_id= :colegioId and r.nivel_id = :gradoId and r.res_ano = :ano group by r.colegio_id order by r.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndGradoAndAno(Long colegioId, Long gradoId, Long ano);

    @Query(value = "select c.name as colegio, SUM(cant_aprobados) as aprobados, SUM(cant_desertados) as desertados, SUM(cant_repitentes) as repitentes, SUM(cant_reprobados) as reprobados, SUM(tasa_asistencia) as asistencia, SUM(tasa_de_cobertura) as cobertura, SUM(alumnos_docentes) as alumnosDocentes, SUM(internet_access) as internet, SUM(computadores_alumnos) as computadores  from resumen_ano r " +
            "join colegio c on r.colegio_id = c.id " +
            "where r.colegio_id= :colegioId and r.nivel_id = :gradoId and r.res_ano = :ano and r.res_periodo= :periodo group by r.colegio_id order by r.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndGradoAndAnoAndPeriodo(Long colegioId, Long gradoId, Long ano, Long periodo);
}
