package rh.javapleno.usuario.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.model.dto.UsuarioDTO;
import rh.javapleno.usuario.service.UsuarioService;

import java.util.List;

@CrossOrigin
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;


    private final PasswordEncoder passwordEncoder;


    @PostMapping
    public UsuarioDTO salvar(@RequestBody Usuario usuario) {
        String senhaCriptrografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptrografada);
        return new ModelMapper().map(usuarioService.salvar(usuario), UsuarioDTO.class);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> alterar(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(
                new ModelMapper().map(usuarioService.alterar(usuario), UsuarioDTO.class),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }


    @GetMapping
    public List<UsuarioDTO> pesquisaTodos() {
        return usuarioService.pesquisaTodos();
    }

    @GetMapping(value = "/{id}")
    public UsuarioDTO pesquisarId(@PathVariable Long id) {
        return new ModelMapper().map(usuarioService.pesquisarId(id), UsuarioDTO.class);
    }

    @GetMapping(value = "/busca")
    public ResponseEntity<Usuario> pesquisarEmail(@RequestParam String email) {
        return usuarioService.pesquisarEmail(email);
    }

}
