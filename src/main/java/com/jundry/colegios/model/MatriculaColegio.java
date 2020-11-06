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
@Table(name = "matricula_colegio")
@EntityListeners(AuditingEntityListener.class)
public class MatriculaColegio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(columnDefinition = "colegio_id", nullable = false)
    private Colegios colegio;

    @Column(nullable = false)
    private Long mat_cant_alum;

    @Column(nullable = false)
    private Long mat_actual_ano;

    @Column(nullable = false)
    private Long mat_periodo;

    @OneToOne
    @JoinColumn(columnDefinition = "nivel_id", nullable = false)
    private NivelGrado nivel;

    @Column(nullable = false)
    private Long mat_grado;

    @Column(nullable = false)
    private Long mat_extraedad;
}
