package com.jundry.colegios.repository;

import com.jundry.colegios.model.Docentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docentes,Long> {
    @Query(value = "select c.name as colegio, SUM(do_cant) as cantidad from docente d " +
            "join colegio c on d.colegio_id = c.id " +
            "where d.do_actual_ano = :ano and d.do_periodo IN ('1','2','3','4') group by d.colegio_id order by d.id ASC ", nativeQuery = true)
    List<?> findAllByAno(Long ano);

    @Query(value = "select c.name as colegio, SUM(do_cant) as cantidad from docente d " +
            "join colegio c on d.colegio_id = c.id " +
            "where d.do_actual_ano = :ano and d.do_periodo = :periodo group by d.colegio_id order by d.id ASC ", nativeQuery = true)
    List<?> findAllByAnoAndPeriodo(Long ano, Long periodo);


    @Query(value = "select c.name as colegio, SUM(do_cant) as cantidad from docente d " +
            "join colegio c on d.colegio_id = c.id " +
            "where d.colegio_id= :colegio and  d.do_actual_ano = :ano and d.do_periodo IN ('1','2','3','4') group by d.colegio_id order by d.id ASC ", nativeQuery = true)
    List<?> findAllByColegioAndAno(Long colegio,Long ano);


    @Query(value = "select c.name as colegio, SUM(do_cant) as cantidad from docente d " +
            "join colegio c on d.colegio_id = c.id " +
            "where d.colegio_id= :colegio and d.do_actual_ano = :ano and d.do_periodo= :periodo group by d.colegio_id order by d.id ASC ", nativeQuery = true)
    List<?> findAllByColegioAndAnoAndPeriodo(Long colegio,Long ano,Long periodo);


}
