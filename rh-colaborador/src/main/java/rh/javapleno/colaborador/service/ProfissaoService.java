package rh.javapleno.colaborador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.PagamentoFeignClient;
import rh.javapleno.colaborador.model.Profissao;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final PagamentoFeignClient pagamentoFeignClient;

    public ResponseEntity<Profissao> pesquisarId(Long id) {
        return pagamentoFeignClient.pesquisarId(id);
    }
}
