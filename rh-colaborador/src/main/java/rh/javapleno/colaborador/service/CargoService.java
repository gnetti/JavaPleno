package rh.javapleno.colaborador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.PagamentoFeignClient;
import rh.javapleno.colaborador.model.Cargo;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final PagamentoFeignClient pagamentoFeignClient;

    public ResponseEntity<Cargo> pesquisarId(Long id) {
        return pagamentoFeignClient.pesquisarId(id);
    }

}
