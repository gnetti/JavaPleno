package rh.javapleno.colaborador.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.colaborador.model.Pagamento;
import rh.javapleno.colaborador.service.PagamentoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<List<Pagamento>> pesquisarColId(@PathVariable Long id) {
        return pagamentoService.pesquisarColId(id);
    }
}
