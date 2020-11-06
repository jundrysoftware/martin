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
@Table(name = "nivel_colegio")
@EntityListeners(AuditingEntityListener.class)
public class NivelColegio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nivel;
}
