package rh.javapleno.colaborador.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.colaborador.model.Colaborador;
import rh.javapleno.colaborador.service.ColaboradorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colaborador")

public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @PostMapping
    public Colaborador salvar(@RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }

    @GetMapping
    public List<Colaborador> PesquisaTodos() {
        return colaboradorService.pesquisaTodos();
    }

    @GetMapping("{id}")
    public Optional<Colaborador> pesquisarId(@PathVariable Long id) {
        return colaboradorService.pesquisarId(id);
    }
    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Colaborador colaborador){
       colaboradorService.alterar(colaborador);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        colaboradorService.deletar(id);
    }

}
