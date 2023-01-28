package dev.fujioka.java.avancado.web.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class Bolsista implements Serializable {


    private Integer id;

    private String nome;

    private String matricula;

}
