package rh.javapleno.colaborador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.UsuarioFeignClient;
import rh.javapleno.colaborador.model.Usuario;
import rh.javapleno.colaborador.model.dto.UsuarioDTO;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioFeignClient usuarioFeignClient;

    public ResponseEntity<Usuario> pesquisarId(Long id) {
        return usuarioFeignClient.pesquisarId(id);
    }

    public Object pesquisarEmail(String email) {
        return usuarioFeignClient.pesquisarEmail(email);
    }

    public UsuarioDTO pesquisarIdColaborador(Long id) {
        return usuarioFeignClient.pesquisarIdColaborador(id);
    }
}
