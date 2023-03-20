package rh.javapleno.pagamento.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long colaboradorId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Double valorDia;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "situacao_pagamento", nullable = true)
    private Situacao situacao;

    private char status;

}
