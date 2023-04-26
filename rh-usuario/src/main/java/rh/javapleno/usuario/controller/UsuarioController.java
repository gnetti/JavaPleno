package rh.javapleno.usuario.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.enums.Situacao;
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
@Tag(name = "Usuário")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Cadastro de usuário.")
    @PostMapping
    public UsuarioDTO salvar(@RequestBody Usuario usuario) {
        return new ModelMapper().map(usuarioService.salvar(usuario), UsuarioDTO.class);
    }

    @Operation(summary = "Alterar cadastro de usuário.")
    @PutMapping
    public ResponseEntity<UsuarioDTO> alterar(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(
                new ModelMapper().map(usuarioService.alterar(usuario), UsuarioDTO.class),
                HttpStatus.OK);
    }

    @Operation(summary = "Deleta usuário por id.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @Operation(summary = "Busca todos os usuários.")
    @GetMapping
    public List<UsuarioDTO> pesquisaTodos() {
        return usuarioService.pesquisaTodos();
    }

    @Operation(summary = "Pesquisa usuario por id.")
    @GetMapping(value = "/{id}")
    public UsuarioDTO pesquisarId(@PathVariable Long id) {
        return new ModelMapper().map(usuarioService.pesquisarId(id), UsuarioDTO.class);
    }

    @Operation(summary = "Pesquisa usuário por email.")
    @GetMapping(value = "/busca")
    public ResponseEntity<Usuario> pesquisarEmail(@RequestParam String email) {
        return usuarioService.pesquisarEmail(email);
    }

    @Operation(summary = "Pesquisa por email e nome..")
    @GetMapping(value = "/busca/nome")
    public Usuario pesquisarEmailNome(@RequestParam String email) {
        return new ModelMapper().map(usuarioService.pesquisarEmailNome(email), Usuario.class);
    }
    @Operation(summary = "Pesquisa todos os colaboradores.")
    @GetMapping(value = "/colaborador")
    public List<UsuarioDTO> pesquisaTodosColaborador() {
        return usuarioService.pesquisaTodosColaborador();
    }

    @Operation(summary = "Busca usuário por nome.")
    @RequestMapping(value = "/colaborador/nome", method = RequestMethod.GET)
    public List<Usuario> findByName(@RequestParam(name = "nome", required = true) String nome) {
        List<Usuario> listUsuario = usuarioService.pesquisaNome(nome);
        return listUsuario;
    }

    @Operation(summary = "Busca Colaborador por id.")
    @GetMapping(value = "/colaborador/{id}")
    public UsuarioDTO pesquisarIdColaborador(@PathVariable Long id) {
        return new ModelMapper().map(usuarioService.pesquisarIdColaborador(id), UsuarioDTO.class);
    }

    @Operation(summary = "Busca colaborador por email.")
    @GetMapping(value = "/colaborador/email")
    public UsuarioDTO pesquisarIdColaborador(@RequestParam String email) {
        return new ModelMapper().map(usuarioService.pesquisarEmailColaborador(email), UsuarioDTO.class);
    }

    @Operation(summary = "Busca usuáiro por login.")
    @GetMapping(value = "/login")
    public ResponseEntity<Optional<Usuario>> pesquisarLogin(@RequestParam String email) {
        return usuarioService.pesquisarLogin(email);
    }

    @GetMapping(value = "/login/email")
    public UsuarioDTO pesquisarEmailLogin(@RequestParam String email) {
        return new ModelMapper().map(usuarioService.pesquisarEmailLogin(email), UsuarioDTO.class);
    }

    @Operation(summary = "Alterar senha por id.")
    @PatchMapping("/id/{id}/password/{password}")
    public ResponseEntity<Void> updateSenha(@PathVariable Long id, @PathVariable String password) {
        usuarioService.atualizaSenha(id, password);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca profissão por id.")
    @GetMapping("/profissao-id/{profissaoId}")
    public List<UsuarioDTO> findByProfissaoId(@PathVariable Long profissaoId) {
        return usuarioService.findByProfissaoId(profissaoId);
    }

    @Operation(summary = "Alterar situação por id.")
    @PatchMapping(value = "/id/{id}/situacao/{situacao}")
    public Usuario alterarSituacao(@PathVariable Long id, @PathVariable Situacao situacao) {
        return usuarioService.alterarSituacao(id, situacao);
    }
}
