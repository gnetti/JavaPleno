package rh.javapleno.pagamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.component.ColaboradorFeignClient;
import rh.javapleno.pagamento.model.Colaborador;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorFeignClient colaboradorFeignClient;

    public ResponseEntity<Colaborador> pesquisarId(Long id) {
        return colaboradorFeignClient.pesquisarId(id);
    }
}
