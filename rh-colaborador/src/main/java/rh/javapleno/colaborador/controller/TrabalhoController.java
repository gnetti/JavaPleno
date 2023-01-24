package rh.javapleno.colaborador.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.colaborador.model.Colaborador;
import rh.javapleno.colaborador.model.Trabalho;
import rh.javapleno.colaborador.service.ColaboradorService;
import rh.javapleno.colaborador.service.TrabalhoService;

import java.util.Optional;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/pagamento")
public class TrabalhoController {

    private final TrabalhoService trabalhoService;

    private final ColaboradorService colaboradorService;

    @GetMapping("{id}")
    public Optional<Colaborador> pesquisarId(@PathVariable Long id) {

        return colaboradorService.pesquisarId(id);
    }

    @PostMapping("/{id}")

    public ResponseEntity<Trabalho> salvar(@RequestBody Trabalho trabalho, @PathVariable Long id) {
        Optional<Colaborador> colaboradorOptional = pesquisarId(id);
        trabalho.setColaborador(colaboradorOptional.get());
        trabalho.setValorDia(colaboradorOptional.get().getValorDia());
        return ResponseEntity.status(HttpStatus.CREATED).body(trabalhoService.salvar(trabalho));
    }

}
