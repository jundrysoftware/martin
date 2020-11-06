package com.jundry.colegios.repository;

import com.jundry.colegios.model.DesempenoGlobal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DesempenoGlobalRepository extends JpaRepository<DesempenoGlobal, Long> {
    @Query(value = "select c.name as colegio, m.materia as materia, SUM(des_porcentaje) as result from desempeno_global dp " +
            "join materia m on dp.materia_id = m.id " +
            "join colegio c on dp.colegio_id = c.id " +
            "where dp.materia_id = :materiaId and dp.des_actual_ano = :ano and dp.des_periodo IN ('1','2','3','4') GROUP By dp.colegio_id order by dp.id desc ", nativeQuery = true)
    List<?> findAllByUtil(Long materiaId, Long ano);

    @Query(value = "select c.name as colegio, m.materia as materia, SUM(des_porcentaje) as result from desempeno_global dp " +
            "join materia m on dp.materia_id = m.id " +
            "join colegio c on dp.colegio_id = c.id " +
            "where dp.materia_id = :materiaId and dp.des_actual_ano = :ano and dp.des_periodo= :periodo GROUP By dp.colegio_id order by dp.des_periodo desc ", nativeQuery = true)
    List<?> findAllByUtilTwo(Long materiaId, Long ano,Long periodo);

    @Query(value = "select c.name as colegio, m.materia as materia, SUM(des_porcentaje) as result from desempeno_global dp " +
            "join colegio c on dp.colegio_id = c.id " +
            "join materia m on dp.materia_id = m.id " +
            "where dp.colegio_id = :colegioId and dp.materia_id = :materiaId and dp.des_actual_ano = :ano and dp.des_periodo IN ('1','2','3','4') GROUP By dp.colegio_id order by dp.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndMateriaAndDesActualAno(Long colegioId, Long materiaId, Long ano);

    @Query(value = "select c.name as colegio, m.materia as materia, SUM(des_porcentaje) as result from desempeno_global dp " +
            "join colegio c on dp.colegio_id = c.id " +
            "join materia m on dp.materia_id = m.id " +
            "where dp.colegio_id = :colegioId and dp.materia_id = :materiaId and dp.des_actual_ano = :ano and dp.des_periodo = :periodo order by dp.des_periodo desc ", nativeQuery = true)
    List<?> findAllByColegioAndMateriaAndDesActualAnoAndPeriodo(Long colegioId, Long materiaId, Long ano, Long periodo);
}
