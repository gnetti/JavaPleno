package rh.javapleno.pagamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.component.UsuarioFeignClient;
import rh.javapleno.pagamento.model.Usuario;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioFeignClient usuarioFeignClient;


    public ResponseEntity<Usuario> pesquisarId(Long id) {
        return usuarioFeignClient.pesquisarId(id);
    }

    public ResponseEntity<Usuario> pesquisarTodos(){
        return usuarioFeignClient.pesquisarTodos();
    }

}
