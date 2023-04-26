package rh.javapleno.usuario.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.usuario.model.Profissao;
import rh.javapleno.usuario.service.ProfissaoService;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/profissao")
@Tag(name = "Profissão")
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @Operation(summary = "Pesquisa profissão por id")
    @GetMapping("/{id}")
    public ResponseEntity<Profissao> pesquisarId(@PathVariable Long id) {
        return profissaoService.pesquisarId(id);
    }

    @Operation(summary = "Busca todas as profissões.")
    @GetMapping
    public List<Profissao> pesquisaTodos() {
        return profissaoService.pesquisaTodos();
    }
}


