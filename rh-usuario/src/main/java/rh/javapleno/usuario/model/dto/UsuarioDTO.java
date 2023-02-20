package rh.javapleno.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rh.javapleno.usuario.model.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsuarioDTO {

    @Id
    private Long id;
    private String nome;

    private String email;
    private char colaborador;
    private Long profissaoId;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

}
