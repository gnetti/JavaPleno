package rh.javapleno.usuario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.model.Role;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;


    private final PasswordEncoder passwordEncoder;


    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        String senhaCriptrografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptrografada);
        return usuarioService.salvar(usuario);
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Usuario usuario) {
        Usuario usuarioEntity = pesquisarId(usuario.getId()).orElseThrow();
        String senhaCriptrografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptrografada);
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioService.alterar(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }


    @GetMapping
    public List<Usuario> PesquisaTodos() {
        return usuarioService.pesquisaTodos();
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> pesquisarId(@PathVariable Long id) {
        return usuarioService.pesquisarId(id);
    }

    @GetMapping(value = "/busca")
    public ResponseEntity<Usuario> pesquisarEmail(@RequestParam String email) {
        return usuarioService.pesquisarEmail(email);
    }
}
