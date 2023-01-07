package rh.javapleno.pagamento.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.service.PagamentoService;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @HystrixCommand(fallbackMethod = "getPagamentoAlternative")
    @GetMapping(value = "/{colaboradorId}/dias/{dias}")
    public ResponseEntity<Pagamento> getPagamento(@PathVariable Long colaboradorId, @PathVariable Integer dias) {
    Pagamento pagamento = pagamentoService.getPagamento(colaboradorId,dias);
    return ResponseEntity.ok(pagamento);

    }
    public ResponseEntity<Pagamento> getPagamentoAlternative( Long colaboradorId,  Integer dias) {
        Pagamento pagamento = new Pagamento("Luiz",400.0, dias);
        return ResponseEntity.ok(pagamento);

    }
}
