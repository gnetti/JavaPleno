package rh.javapleno.pagamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.service.UsuarioService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id) {
        return usuarioService.pesquisarId(id);
    }



}
