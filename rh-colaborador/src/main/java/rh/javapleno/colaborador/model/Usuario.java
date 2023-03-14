package rh.javapleno.colaborador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String email;
//    private String password;
    private char colaborador;
//    private Endereco endereco;
    private Situacao situacao;
}
