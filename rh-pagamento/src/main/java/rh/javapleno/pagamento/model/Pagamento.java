package rh.javapleno.pagamento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;


    private String nome;
    private Double valorDia;
    private Integer dias;

    public double getTotal() {
        return dias * valorDia;
    }
}


