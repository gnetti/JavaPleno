package rh.javapleno.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import rh.javapleno.usuario.enums.Situacao;
import rh.javapleno.usuario.model.Endereco;
import rh.javapleno.usuario.model.Role;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @Id
    private Long id;

    @CPF
    private String cpf;

    private String rg;

    private String matricula;

    private String nome;

    private String email;

    private char colaborador;

    private Long profissaoId;

    @Embedded
    private Endereco endereco;

    private Situacao situacao;

    @Column(name = "primeiro_acesso")
    private Boolean primeiroAcesso;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

}
