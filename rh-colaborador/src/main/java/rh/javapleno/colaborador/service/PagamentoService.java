package rh.javapleno.colaborador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.PagamentoFeignClient;
import rh.javapleno.colaborador.model.Pagamento;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoFeignClient pagamentoFeignClient;

    public ResponseEntity<List<Pagamento>> pesquisarColId(Long id) {

        ResponseEntity<List<Pagamento>> pagamento = (pagamentoFeignClient.pesquisarColId(id));
        return pagamento;
    }

}
