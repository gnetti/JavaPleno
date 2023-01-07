package rh.javapleno.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.component.ColaboradorFeignClient;
import rh.javapleno.pagamento.model.Colaborador;
import rh.javapleno.pagamento.model.Pagamento;

@Service
public class PagamentoService {
    @Autowired
    private ColaboradorFeignClient colaboradorFeignClient;

    public Pagamento getPagamento(long colaboradorId, int dias) {

        Colaborador colaborador = colaboradorFeignClient.findById((colaboradorId)).getBody();
        return new Pagamento(colaborador.getNome(), colaborador.getValorDia(), dias);
    }
}
