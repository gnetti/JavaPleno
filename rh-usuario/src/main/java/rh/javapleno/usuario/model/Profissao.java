package rh.javapleno.usuario.model;


import lombok.Data;
import rh.javapleno.usuario.enums.Situacao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class Profissao{

    private Long id;

    private String descricao;

    private Double valorDia;

    @Enumerated(EnumType.ORDINAL)
    private Situacao situacao;

}
