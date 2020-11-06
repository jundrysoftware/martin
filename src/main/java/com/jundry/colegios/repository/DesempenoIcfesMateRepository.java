package com.jundry.colegios.repository;

import com.jundry.colegios.model.DesempenoIcfesMate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesempenoIcfesMateRepository extends JpaRepository<DesempenoIcfesMate, Long> {
    @Query(value = "select dim.* from desempeno_icfes_mate dim " +
            "join colegio c on dim.colegio_id = c.id " +
            "join materia m on dim.materia_id = m.id " +
            "where dim.colegio_id = :colegioId and dim.materia_id = :materiaId and dim.des_actual_ano = :ano  order by dim.id desc ", nativeQuery = true)
    List<DesempenoIcfesMate> findAllByColegioAndMateriaAndAno(Long colegioId, Long materiaId, Long ano);

    @Query(value = "select dim.* from desempeno_icfes_mate dim " +
            "join materia c on dim.materia_id = c.id " +
            "where dim.materia_id = :materiaId and dim.des_actual_ano = :ano  order by dim.des_result ASC ", nativeQuery = true)
    List<DesempenoIcfesMate> findAllByMateriaAndAno(Long materiaId, Long ano);
}
