package rh.javapleno.usuario.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {

        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> PesquisaTodos() {
        return usuarioService.pesquisaTodos();
    }

    @GetMapping("{id}")
    public Optional<Usuario> pesquisarId(@PathVariable Long id) {

        return usuarioService.pesquisarId(id);
    }

    @GetMapping("/busca")
    public ResponseEntity<Usuario> pesquisarEmail(@RequestParam String email) {

        return usuarioService.pesquisarEmail(email);
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Usuario usuario) {
        usuarioService.alterar(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
