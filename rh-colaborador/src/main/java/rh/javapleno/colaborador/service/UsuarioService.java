package rh.javapleno.colaborador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.UsuarioFeignClient;
import rh.javapleno.colaborador.model.Usuario;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioFeignClient usuarioFeignClient;

    public ResponseEntity<Usuario> pesquisarId(Long id) {
        return usuarioFeignClient.pesquisarId(id);
    }
}
