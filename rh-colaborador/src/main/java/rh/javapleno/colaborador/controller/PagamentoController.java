package rh.javapleno.colaborador.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.colaborador.model.dto.PagamentoDTO;
import rh.javapleno.colaborador.service.PagamentoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<List<PagamentoDTO>> pesquisarColId(@PathVariable Long id) {
        return pagamentoService.pesquisarColId(id);
    }
}
