package rh.javapleno.pagamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.model.Situacao;
import rh.javapleno.pagamento.service.ProfissaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profissao")
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @PostMapping
    public Profissao salvar(@RequestBody Profissao profissao) {

        return profissaoService.salvar(profissao);
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Profissao profissao) {
        profissaoService.alterar(profissao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        profissaoService.deletar(id);
    }

    @GetMapping
    public List<Profissao> PesquisaTodos() {
        return profissaoService.pesquisaTodos();
    }

    @GetMapping("{id}")
    public Optional<Profissao> pesquisarId(@PathVariable Long id) {
        return profissaoService.pesquisarId(id);
    }

    @PatchMapping(value = "/id/{id}/situacao/{situacao}")
    public Profissao alterarSituacao(@PathVariable Long id, @PathVariable Situacao situacao) {
        return profissaoService.alterarSituacao(id, situacao);
    }

}

