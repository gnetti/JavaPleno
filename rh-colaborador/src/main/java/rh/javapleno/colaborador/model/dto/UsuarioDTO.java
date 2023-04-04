package rh.javapleno.colaborador.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @Id
    private Long id;

    private String matricula;

    private String nome;

    private String email;

    private char colaborador;

    private Long profissaoId;

}
