package rh.javapleno.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rh.javapleno.pagamento.model.Colaborador;
import rh.javapleno.pagamento.model.Pagamento;

import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {

    @Value("${rh-colaborador.host}")
    private String pagamentoHost;

    @Autowired
    private RestTemplate restTemplate;

    public Pagamento getPagamento(long colaboradorId, int dias) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + colaboradorId);

        Colaborador colaborador = restTemplate.getForObject(pagamentoHost + "/colaborador/{id}", Colaborador.class, uriVariables);
        return new Pagamento(colaborador.getNome(), colaborador.getValorDia(), dias);
    }
}
