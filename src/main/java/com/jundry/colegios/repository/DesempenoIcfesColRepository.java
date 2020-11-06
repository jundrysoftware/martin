package com.jundry.colegios.repository;

import com.jundry.colegios.model.DesempenoIcfesCol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesempenoIcfesColRepository extends JpaRepository<DesempenoIcfesCol,Long> {
    @Query(value = "select dic.* from desempeno_icfes_col dic " +
            "join colegio c on dic.colegio_id = c.id " +
            "where dic.colegio_id = :colegioId and dic.des_actual_ano = :ano  order by dic.id desc ", nativeQuery = true)
    List<DesempenoIcfesCol>  findAllByColegioAndDesActualAno(Long colegioId, Long ano);


    @Query(value = "select dic.* from desempeno_icfes_col dic " +
            "where dic.des_actual_ano = :ano  order by dic.id desc ", nativeQuery = true)
    List<DesempenoIcfesCol>  findAllByAno(Long ano);


}
