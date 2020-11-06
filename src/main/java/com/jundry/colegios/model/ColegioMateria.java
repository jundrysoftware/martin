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
@Table(name = "colegio_materia")
@EntityListeners(AuditingEntityListener.class)
public class ColegioMateria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(columnDefinition = "colegio_id", nullable = false)
    private Colegios colegio;

    @OneToOne
    @JoinColumn(columnDefinition = "materia_id", nullable = false)
    private Materia materia;
}
