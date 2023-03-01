package rh.javapleno.pagamento.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class PagamentoDTO {

    @Id
    private Long id;

    private String nomeColaborador;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Double valorDia;

}
