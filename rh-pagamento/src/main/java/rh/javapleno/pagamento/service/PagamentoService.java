package rh.javapleno.pagamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.PagamentoRepository;
import rh.javapleno.pagamento.model.Pagamento;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public Pagamento salvar(Pagamento trabalho) {
        return pagamentoRepository.save(trabalho);
    }
}
