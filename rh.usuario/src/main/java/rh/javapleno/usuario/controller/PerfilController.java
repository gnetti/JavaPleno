package rh.javapleno.usuario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.model.Perfil;
import rh.javapleno.usuario.service.PerfilService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/perfil")
public class PerfilController {
    private final PerfilService perfilService;

    @PostMapping
    public Perfil salvar(@RequestBody Perfil perfil) {

        return perfilService.salvar(perfil);
    }

    @GetMapping
    public List<Perfil> PesquisaTodos() {
        return perfilService.pesquisaTodos();
    }

    @GetMapping("{id}")
    public Optional<Perfil> pesquisarId(@PathVariable Long id) {

        return perfilService.pesquisarId(id);
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Perfil perfil) {
        perfilService.alterar(perfil);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        perfilService.deletar(id);
    }
}
