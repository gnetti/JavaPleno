package rh.javapleno.oauth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;


    private Set<Perfil> perfil = new HashSet<>();
}
