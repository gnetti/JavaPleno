package rh.javapleno.colaborador.controller;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.colaborador.model.Colaborador;
import rh.javapleno.colaborador.service.ColaboradorService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/colaborador")

public class ColaboradorController {

    @Autowired
    private Environment env;


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

        log.info("PORT = " + env.getProperty("local.server.port"));

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
