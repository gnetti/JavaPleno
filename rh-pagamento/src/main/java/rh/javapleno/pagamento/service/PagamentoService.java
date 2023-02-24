package rh.javapleno.pagamento.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import rh.javapleno.pagamento.Repository.PagamentoRepository;
import rh.javapleno.pagamento.exceptions.ColaboradorNaoEncontrado;
import rh.javapleno.pagamento.exceptions.PagamentoNaoEncontrado;
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
        } catch (ColaboradorNaoEncontrado e) {
            log.error("Colaborador Não Encontrado", e);
        }
        return ResponseEntity.noContent().build();
    }

    public void alterar(@PathVariable Long id, @RequestBody Pagamento pagamento){
        Pagamento pagamentoEntity = pagamentoRepository.findById(pagamento.getId())
                .orElseThrow(() -> new PagamentoNaoEncontrado("Pagamento Informado não Existe"));
        pagamentoEntity.setData(pagamento.getData());
        pagamentoEntity.setValorDia(pagamento.getValorDia());
        pagamentoEntity.setColaboradorId(pagamento.getColaboradorId());
    }

    public List<Pagamento> pesquisarTodos(){

        return pagamentoRepository.findAll();
    }

    
}
