package rh.javapleno.pagamento.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rh.javapleno.pagamento.enums.Situacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_profissao")
public class Profissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "o campo não deve ser vazio")
    private String descricao;

    @Column(name ="valor_dia", nullable = true)
    private Double valorDia;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "situacao_profissao",nullable = true)
    private Situacao situacao;


}
