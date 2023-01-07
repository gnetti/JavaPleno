package rh.javapleno.pagamento.service;

import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.model.Pagamento;

@Service
public class PagamentoService {
    public Pagamento getPagamento(long colaboradorId,int dias){
        return new Pagamento("Luiz",200.0,dias);
    }
}
