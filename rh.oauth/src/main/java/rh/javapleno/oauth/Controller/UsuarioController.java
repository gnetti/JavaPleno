package rh.javapleno.oauth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.oauth.model.Usuario;
import rh.javapleno.oauth.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/busca")
    public ResponseEntity<Usuario> findByEmail (@RequestParam String email){
        try {
            Usuario usuario = usuarioService.findByEmail(email);
            return ResponseEntity.ok(usuario);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
