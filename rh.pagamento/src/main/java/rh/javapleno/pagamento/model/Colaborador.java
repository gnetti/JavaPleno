package rh.javapleno.pagamento.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {


    private Long id;
    private String nome;
    private Double valorDia;


}
