package rh.javapleno.pagamento.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.enums.Situacao;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.model.dto.PagamentoDTO;
import rh.javapleno.pagamento.service.PagamentoService;
import rh.javapleno.pagamento.service.ProfissaoService;
import rh.javapleno.pagamento.service.UsuarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamento")
@Tag(name = "Pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    private final UsuarioService usuarioService;
    private final ProfissaoService profissaoService;

    @Operation(summary = "Busca todos os pagamentos.")
    @GetMapping
    public List<PagamentoDTO> pesquisaTodos() {
        return pagamentoService.pesquisaTodos();
    }

    @Operation(summary = "Busca profissão por id.")
    @GetMapping("/profissao/{id}")
    public Optional<Profissao> pesquisarIdPro(@PathVariable Long id) {
        return profissaoService.pesquisarId(id);
    }

    @Operation(summary = "Busca todos os usuários por id.")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id) {
        return usuarioService.pesquisarId(id);
    }

    @Operation(summary = "Salva pagamento")
    @PostMapping("/{id}")
    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.salvar(pagamento, id));
    }

    @Operation(summary = "Realiza pagamento por colaborador id.")
    @PatchMapping("/colaborador/{id}")
    public ResponseEntity<Pagamento> salvarParaColaborador(@RequestBody Pagamento pagamento, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.salvarParaColaborador(pagamento, id));
    }

    @Operation(summary = "Pesquisa colaborador por id.")
    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<List<PagamentoDTO>> pesquisarColId(@PathVariable Long id) {
        return pagamentoService.pesquisarColId(id);
    }

    @Operation(summary = "Altera situação por id.")
    @PatchMapping(value = "/id/{id}/situacao/{situacao}")
    public Pagamento alterarSituacao(@PathVariable Long id, @PathVariable Situacao situacao) {
        return pagamentoService.alterarSituacao(id, situacao);
    }

    @Operation(summary = "Atualiza situação.")
    @PutMapping(value = "/id/{id}/status/{status}")
    public Pagamento alterarStatus(@PathVariable Long id, @PathVariable char status) {
        return pagamentoService.alterarStatus(id, status);
    }

    @Operation(summary = "Busca lançamento por id.")
    @GetMapping("/lancamento/{id}")
    public Pagamento pesquisarIdLan(@PathVariable Long id) {
        return pagamentoService.pesquisarIdLan(id);
    }

    @Operation(summary = "Busca lancamento por data.")
    @GetMapping("/lancamento/data")
    public List<PagamentoDTO> pesquisarPorcolaboradorIdData(@RequestParam Long colaboradorId, @RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim, @RequestParam char status) {
        return pagamentoService.pesquisarPorcolaboradorIdData(colaboradorId, dataInicio, dataFim, status);
    }

    @Operation(summary = "Realiza pagamento.")
    @PatchMapping("/lancamento/pagar")
    public ResponseEntity<Void> pagarPorcolaboradorIdData(@RequestParam Long colaboradorId, @RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim, @RequestParam char status) {
        pagamentoService.pagarPorcolaboradorIdData(colaboradorId, dataInicio, dataFim, status);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Atualiza pagamento.")
    @PutMapping
    public ResponseEntity<Pagamento> alterar(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.alterar(pagamento));
    }
}
