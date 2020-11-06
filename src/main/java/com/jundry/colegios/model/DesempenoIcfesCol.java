package com.jundry.colegios.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "desempeno_icfes_col")
@EntityListeners(AuditingEntityListener.class)
public class DesempenoIcfesCol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(columnDefinition = "colegio_id", nullable = false)
    private Colegios colegio;

    @Column(nullable = false)
    private Long des_actual_ano;

    @Column(nullable = false)
    private String des_result;
}
