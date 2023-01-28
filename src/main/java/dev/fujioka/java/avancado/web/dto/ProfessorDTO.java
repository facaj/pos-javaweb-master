package dev.fujioka.java.avancado.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class ProfessorDTO implements Serializable {
    private String nome;
    private String especialidade;
}
