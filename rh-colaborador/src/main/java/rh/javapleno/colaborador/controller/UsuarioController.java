package rh.javapleno.colaborador.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.colaborador.model.Usuario;
import rh.javapleno.colaborador.model.dto.UsuarioDTO;
import rh.javapleno.colaborador.service.UsuarioService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Pesquisa usuário por id.")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id){

        return usuarioService.pesquisarId(id);
    }

    @Operation(summary = "Pesquisa usuário por email.")
    @GetMapping(value = "/busca")
    public ResponseEntity<Usuario> pesquisarEmail(@RequestParam String email) {
        return (ResponseEntity<Usuario>) usuarioService.pesquisarEmail(email);
    }

    @Operation(summary = "Pesquisa colaborador por id.")
    @GetMapping(value = "/colaborador/{id}")
    public UsuarioDTO pesquisarIdColaborador(@PathVariable Long id) {
        return new ModelMapper().map(usuarioService.pesquisarIdColaborador(id), UsuarioDTO.class);
    }
}
