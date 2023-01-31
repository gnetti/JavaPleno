package rh.javapleno.colaborador.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.colaborador.model.Profissao;
import rh.javapleno.colaborador.service.ProfissaoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profissao")
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Profissao> pesquisarId(@PathVariable Long id){
        return profissaoService.pesquisarId(id);
    }
}
