package rh.javapleno.colaborador.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.component.ProfissaoFeignClient;
import rh.javapleno.colaborador.component.UsuarioFeignClient;
import rh.javapleno.colaborador.model.Profissao;
import rh.javapleno.colaborador.model.Usuario;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoFeignClient profissaoFeignClient;

    public ResponseEntity<Profissao> pesquisarId(Long id) {
        return profissaoFeignClient.pesquisarId(id);
    }
}
