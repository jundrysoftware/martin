package com.jundry.colegios.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resumen_ano")
@EntityListeners(AuditingEntityListener.class)
public class ResumenAno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(columnDefinition = "colegio_id", nullable = false)
    private Colegios colegio;

    @Column(nullable = false)
    private Long cant_aprobados;

    @Column(nullable = false)
    private Long cant_reprobados;

    @Column(nullable = false)
    private Long cant_repitentes;

    @Column(nullable = false)
    private Long cant_desertados;

    @Column(nullable = false)
    private Long tasa_asistencia;

    @Column(nullable = false)
    private Long res_periodo;

    @Column(nullable = false)
    private Long res_ano;

    @Column(nullable = false)
    private Long tasa_de_cobertura;

    @Column(nullable = false)
    private Long alumnos_docentes;

    @Column(nullable = false)
    private Long internet_access;

    @Column(nullable = false)
    private Long computadores_alumnos;

    @OneToOne
    @JoinColumn(columnDefinition = "nivel_id", nullable = false)
    private NivelGrado nivel;
}
