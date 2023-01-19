package rh.javapleno.colaborador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_colaborador")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double valorDia;

    @JsonIgnore
    @OneToMany(mappedBy = "colaborador",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Trabalho> listaTrabalho;


}
