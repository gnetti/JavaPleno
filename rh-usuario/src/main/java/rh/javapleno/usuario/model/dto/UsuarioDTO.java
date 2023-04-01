package rh.javapleno.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rh.javapleno.usuario.model.Role;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

import rh.javapleno.usuario.model.Endereco;
import rh.javapleno.usuario.enums.Situacao;

import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @Id
    private Long id;
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
