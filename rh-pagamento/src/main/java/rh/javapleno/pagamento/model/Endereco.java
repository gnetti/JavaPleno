package rh.javapleno.pagamento.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Endereco {

    @JsonProperty("logradouro")
    private String rua;
    //@ApiModelProperty(example = "123", required = true)
    private Integer numero;
    // @JsonIgnoreProperties
     private String complemento;
    ///@ApiModelProperty(example = "03590170", required = true)
    private String bairro;
    private String cep;
    private String uf;

    @JsonProperty(value = "localidade")
    private String cidade;


}