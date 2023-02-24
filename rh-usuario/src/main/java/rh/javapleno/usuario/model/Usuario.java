package rh.javapleno.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private char colaborador;
    @Embedded
    private Endereco endereco;
    private Long profissaoId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "situacao_usuario")
    @NotNull
    private Situacao situacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_role_usuario",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Role> roles = new HashSet<>();


}