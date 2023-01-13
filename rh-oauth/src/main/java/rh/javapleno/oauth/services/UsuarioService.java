package rh.javapleno.oauth.services;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rh.javapleno.oauth.model.Usuario;
import rh.javapleno.oauth.component.UserFeignClientComponent;

@Log4j2
@Service
public class UsuarioService implements UserDetailsService {


    @Autowired
    private UserFeignClientComponent userFeignClientComponent;

    public Usuario findByEmail(String email) {
        Usuario usuario = userFeignClientComponent.findByEmail(email).getBody();
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userFeignClientComponent.findByEmail(username).getBody();
        if (usuario == null) {
            log.error("Username não encontrado: " + username);
            throw new UsernameNotFoundException("Username encontrado");
        }
        log.info("Username encontrado: " + username);
        return usuario;
    }
}
