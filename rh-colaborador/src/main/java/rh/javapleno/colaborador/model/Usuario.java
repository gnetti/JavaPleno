package rh.javapleno.colaborador.model;

import lombok.Data;

@Data
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String password;
    private char colaborador;
}
