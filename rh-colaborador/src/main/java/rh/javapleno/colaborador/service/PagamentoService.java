package rh.javapleno.colaborador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.PagamentoFeignClient;
import rh.javapleno.colaborador.model.dto.PagamentoDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoFeignClient pagamentoFeignClient;

    public ResponseEntity<List<PagamentoDTO>> pesquisarColId(Long id) {
                return pagamentoFeignClient.pesquisarColId(id);
    }
}
