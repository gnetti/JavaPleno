package rh.javapleno.colaborador.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import rh.javapleno.colaborador.model.Situacao;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class PagamentoDTO {

    @Id
    private Long id;

    private String matriculaColaborador;

    private String nomeColaborador;

    private Long colaboradorId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Double valorDia;

    private Situacao situacao;

    private char status;

}
