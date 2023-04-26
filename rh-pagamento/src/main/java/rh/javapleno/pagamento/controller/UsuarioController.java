package rh.javapleno.pagamento.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.service.UsuarioService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Pesquisa usuário por id.")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id) {
        return usuarioService.pesquisarId(id);
    }

}
