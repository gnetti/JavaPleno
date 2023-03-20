package rh.javapleno.pagamento.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.model.Situacao;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.model.dto.PagamentoDTO;
import rh.javapleno.pagamento.service.PagamentoService;
import rh.javapleno.pagamento.service.ProfissaoService;
import rh.javapleno.pagamento.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    private final UsuarioService usuarioService;
    private final ProfissaoService profissaoService;

    @GetMapping
    public List<PagamentoDTO> PesquisaTodos() {
        return pagamentoService.pesquisaTodos();
    }

    @GetMapping("/profissao/{id}")
    public Optional<Profissao> pesquisarIdPro(@PathVariable Long id) {

        return profissaoService.pesquisarId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id) {
        return usuarioService.pesquisarId(id);
    }

    @PostMapping("/{id}")

    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.salvar(pagamento, id));
    }

    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<List<PagamentoDTO>> pesquisarColId(@PathVariable Long id) {
        return pagamentoService.pesquisarColId(id);
    }

    @PatchMapping(value = "/id/{id}/situacao/{situacao}")
    public Pagamento alterarSituacao(@PathVariable Long id, @PathVariable Situacao situacao) {
        return pagamentoService.alterarSituacao(id,situacao);
    }

    @GetMapping("/lancamento/{id}")
    public Pagamento pesquisarIdLan(@PathVariable Long id) {
        return pagamentoService.pesquisarIdLan(id);
    }

    @PutMapping
    public ResponseEntity<Pagamento> alterar(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.alterar(pagamento));
    }
}

