package rh.javapleno.pagamento.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.model.Colaborador;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.service.ColaboradorService;
import rh.javapleno.pagamento.service.PagamentoService;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;
    private final ColaboradorService colaboradorService;

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> pesquisarId(@PathVariable Long id) {
        return colaboradorService.pesquisarId(id);
    }

    @PostMapping("/{id}")

    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento, @PathVariable Long id) {
        ResponseEntity<Colaborador> colaboradorOptional = pesquisarId(id);
        pagamento.setColaboradorId(colaboradorOptional.getBody().getId());
        pagamento.setValorDia(colaboradorOptional.getBody().getValorDia());
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.salvar(pagamento));
    }
}
