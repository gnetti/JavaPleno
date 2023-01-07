package rh.javapleno.pagamento.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    private String nome;
    private Double valorDia;
    private Integer dias;
    public double getTotal(){
        return dias * valorDia;
    }
}
