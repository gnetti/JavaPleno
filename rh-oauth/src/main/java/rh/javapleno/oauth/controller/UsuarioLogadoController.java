package rh.javapleno.oauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.oauth.model.Usuario;

import java.io.Serializable;

@RestController
public class UsuarioLogadoController implements Serializable{

    private Usuario usuario;
    public UsuarioLogadoController(){
        usuario = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if(context instanceof SecurityContext)
        {
            Authentication authentication = context.getAuthentication();
            if(authentication instanceof Authentication)
            {
                usuario.setEmail(((User)authentication.getPrincipal()).getUsername());
            }
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @GetMapping(value = "/logado")
    public ResponseEntity<Usuario> usuarioLogado(String usuario) {
        try {
            UsuarioLogadoController usuarioLogadoController = new UsuarioLogadoController();
            usuarioLogado(usuarioLogadoController.getUsuario().getEmail());
            return ResponseEntity.status(HttpStatus.FOUND).build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
