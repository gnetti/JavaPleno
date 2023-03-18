package rh.javapleno.colaborador.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long colaboradorId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Double valorDia;

    private Situacao situacao;

}
