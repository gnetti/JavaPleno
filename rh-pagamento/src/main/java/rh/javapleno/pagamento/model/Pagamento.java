package rh.javapleno.pagamento.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message= "o campo não deve ser vazio")
    private Long colaboradorId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message= "o campo não deve ser vazio")
    private LocalDate data;


    @NotBlank(message= "o campo não deve ser vazio")
    private Double valorDia;

}
