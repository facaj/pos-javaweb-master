package dev.fujioka.java.avancado.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class CursoDTO implements Serializable {
    private String nome;
    private String professor;
}
