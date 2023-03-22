package rh.javapleno.colaborador.controller;


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
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id){

        return usuarioService.pesquisarId(id);
    }
    @GetMapping(value = "/busca")
    public ResponseEntity<Usuario> pesquisarEmail(@RequestParam String email) {
        return (ResponseEntity<Usuario>) usuarioService.pesquisarEmail(email);
    }
    @GetMapping(value = "/colaborador/{id}")
    public UsuarioDTO pesquisarIdColaborador(@PathVariable Long id) {
        return new ModelMapper().map(usuarioService.pesquisarIdColaborador(id), UsuarioDTO.class);
    }
}
