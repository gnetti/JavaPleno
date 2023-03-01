package rh.javapleno.colaborador.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rh.javapleno.colaborador.model.Endereco;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

//    private final RestTemplate restTemplate;

    public Endereco getEndereco(String cep) {
        String Url = "https://viacep.com.br/ws/" + cep + "/json";
        Endereco endereco = new RestTemplate().getForObject(Url, Endereco.class);

        return endereco;
    }
}