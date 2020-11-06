package com.jundry.colegios.repository;

import com.jundry.colegios.model.DesempenoGrados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesempenoGradosRepository extends JpaRepository<DesempenoGrados, Long> {

    @Query(value = "select c.name as colegio, m.materia as materia, dg.des_porcentaje as porcentaje  from desempeno_grados dg " +
            "join colegio c on dg.colegio_id = c.id " +
            "join materia m on dg.materia_id = m.id " +
            "join nivel_grado ng on dg.colegio_id = ng.id " +
            "where dg.colegio_id = :colegioId and dg.materia_id = :materiaId and dg.des_actual_ano = :ano and dg.des_nivel_id = :nivelId and dg.des_periodo IN ('1','2','3','4') group by dg.colegio_id order by dg.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndDesActualAnoAndDesNivel(Long colegioId, Long materiaId, Long ano, Long nivelId);

    @Query(value = "select c.name as colegio, m.materia as materia, dg.des_porcentaje as porcentaje  from desempeno_grados dg " +
            "join colegio c on dg.colegio_id = c.id " +
            "join materia m on dg.materia_id = m.id " +
            "join nivel_grado ng on dg.colegio_id = ng.id " +
            "where dg.colegio_id = :colegioId and dg.materia_id = :materiaId and dg.des_actual_ano = :ano and dg.des_nivel_id = :nivelId and dg.des_periodo= :periodo group by dg.colegio_id order by dg.id desc ", nativeQuery = true)
    List<?> findAllByColegioAndMateriaAndAnoAndGradoAndPeriodo(Long colegioId, Long materiaId, Long ano, Long nivelId, Long periodo);


    @Query(value = "select c.name as colegio, m.materia as materia, dg.des_porcentaje as porcentaje  from desempeno_grados dg " +
            "join colegio c on dg.colegio_id = c.id " +
            "join materia m on dg.materia_id = m.id " +
            "join nivel_grado ng on dg.des_nivel_id = ng.id " +
            "where dg.materia_id = :materiaId and dg.des_actual_ano = :ano and dg.des_nivel_id = :nivelId and dg.des_periodo IN ('1','2','3','4') group by dg.colegio_id order by dg.id desc ", nativeQuery = true)
    List<?> findAllByDesActualAnoAndDesNivel(Long materiaId, Long ano, Long nivelId);


    @Query(value = "select c.name as colegio, m.materia as materia, dg.des_porcentaje as porcentaje  from desempeno_grados dg " +
            "join colegio c on dg.colegio_id = c.id " +
            "join materia m on dg.materia_id = m.id " +
            "join nivel_grado ng on dg.colegio_id = ng.id " +
            "where dg.materia_id = :materiaId and dg.des_actual_ano = :ano and dg.des_nivel_id = :nivelId and dg.des_periodo=:periodo group by dg.colegio_id order by dg.id desc ", nativeQuery = true)
    List<?> findAllByateriaAndAnoAndGradoAndPeriodo(Long materiaId, Long ano, Long nivelId, Long periodo);
}
