package rh.javapleno.usuario.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.tokens.BlockEndToken;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.model.dto.UsuarioDTO;
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
    public UsuarioDTO salvar(@RequestBody Usuario usuario) {
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

    @GetMapping(value = "/busca/nome")
    public Usuario pesquisarEmailNome(@RequestParam String email) {
        return new ModelMapper().map(usuarioService.pesquisarEmailNome(email), Usuario.class);
    }

    @GetMapping(value = "/colaborador")
    public List<UsuarioDTO> pesquisaTodosColaborador() {
        return usuarioService.pesquisaTodosColaborador();
    }

    @RequestMapping(value = "/colaborador/nome", method = RequestMethod.GET)
    public List<Usuario> findByName(@RequestParam(name = "nome", required = true) String nome) {
        List<Usuario> listUsuario = usuarioService.pesquisaNome(nome);
        return listUsuario;
    }

    @GetMapping(value = "/colaborador/{id}")
    public UsuarioDTO pesquisarIdColaborador(@PathVariable Long id) {
        return new ModelMapper().map(usuarioService.pesquisarIdColaborador(id), UsuarioDTO.class);
    }

    @GetMapping(value = "/colaborador/email")
    public UsuarioDTO pesquisarIdColaborador(@RequestParam String email) {
        return new ModelMapper().map(usuarioService.pesquisarEmailColaborador(email), UsuarioDTO.class);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Optional<Usuario>> pesquisarLogin(@RequestParam String email) {
        return usuarioService.pesquisarLogin(email);
    }

    @GetMapping(value = "/login/email")
    public UsuarioDTO pesquisarEmailLogin(@RequestParam String email) {
        return new ModelMapper().map(usuarioService.pesquisarEmailLogin(email), UsuarioDTO.class);
    }
}
