package rh.javapleno.oauth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.javapleno.oauth.component.UsuarioFeignClint;
import rh.javapleno.oauth.model.Usuario;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
   private UsuarioFeignClint usuarioFeignClint;

    public Usuario findByEmail(String email) {
        Usuario usuario = usuarioFeignClint.findByEmail(email).getBody();
        if (usuario == null) {
            log.error("E-mail não encontrado: " + email);
            throw new IllegalArgumentException("E-mail não encontrado");
        }
        log.info("Email encontrado: " + email);
        return usuario;
    }
}
