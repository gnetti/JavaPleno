package rh.javapleno.pagamento.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.enums.Situacao;
import rh.javapleno.pagamento.service.ProfissaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profissao")
@Tag(name = "Profissão")
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @Operation(summary = "Cadastra profissão.")
    @PostMapping
    public Profissao salvar(@RequestBody Profissao profissao) {
        profissao.setSituacao(Situacao.ATIVO);
        return profissaoService.salvar(profissao);
    }

    @Operation(summary = "Atualiza profissão.")
    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Profissao profissao) {
        profissaoService.alterar(profissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Deleta profissão por id.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        profissaoService.deletar(id);
    }

    @Operation(summary = "busca todas as profissões.")
    @GetMapping
    public List<Profissao> pesquisaTodos() {
        return profissaoService.pesquisaTodos();
    }

    @Operation(summary = "Pesquisa profissão por idi.")
    @GetMapping("{id}")
    public Optional<Profissao> pesquisarId(@PathVariable Long id) {
        return profissaoService.pesquisarId(id);
    }

    @Operation(summary = "Altera situação por id.")
    @PatchMapping(value = "/id/{id}/situacao/{situacao}")
    public Profissao alterarSituacao(@PathVariable Long id, @PathVariable Situacao situacao) {
        return profissaoService.alterarSituacao(id, situacao);
    }

}

