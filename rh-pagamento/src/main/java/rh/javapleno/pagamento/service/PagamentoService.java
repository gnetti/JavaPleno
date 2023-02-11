package rh.javapleno.pagamento.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.Repository.PagamentoRepository;
import rh.javapleno.pagamento.model.Pagamento;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public  Pagamento salvar(Pagamento trabalho) {
        return pagamentoRepository.save(trabalho);
    }

    public ResponseEntity <List<Pagamento>> pesquisarColId(Long id) {
        try {
            List<Pagamento> pagamento = (pagamentoRepository.findByColaboradorId(id));
            return ResponseEntity.ok(pagamento);
        } catch (RuntimeException e) {
            log.error("Erro na colsulta", e);
        }
        return ResponseEntity.noContent().build();
    }
}