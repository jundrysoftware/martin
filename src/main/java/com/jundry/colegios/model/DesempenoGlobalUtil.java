package com.jundry.colegios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DesempenoGlobalUtil implements Serializable {
    private String colegio;
    private String materia;
    private Float result;
}
