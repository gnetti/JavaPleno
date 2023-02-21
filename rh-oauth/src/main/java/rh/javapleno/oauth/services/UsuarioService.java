package rh.javapleno.oauth.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rh.javapleno.oauth.component.UsuarioFeignClient;
import rh.javapleno.oauth.model.Usuario;

@Log4j2
@Service
public class UsuarioService implements UserDetailsService {


    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    public Usuario findByEmail(String email) {
        Usuario usuario = usuarioFeignClient.findByEmail(email).getBody();
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioFeignClient.findByEmail(username).getBody();
        if (usuario == null) {
            log.error("Username não encontrado: " + username);
            throw new UsernameNotFoundException("Username encontrado");
        } else if (usuario.getRoles().isEmpty()) {
            throw new RuntimeException("Usuário não possui regras para acessar o sistema.");
        }
        log.info("Username encontrado: " + username);
        return usuario;
    }
    }
