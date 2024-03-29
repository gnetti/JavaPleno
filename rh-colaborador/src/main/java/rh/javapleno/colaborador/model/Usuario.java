package rh.javapleno.colaborador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private Long id;

    private String matricula;

    private String nome;

    private String email;

    private char colaborador;

    private Situacao situacao;

    private Long profissaoId;
}
