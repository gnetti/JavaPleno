package rh.javapleno.usuario.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.usuario.component.ProfissaoFeignClient;
import rh.javapleno.usuario.model.Profissao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoFeignClient profissaoFeignClient;

    public ResponseEntity<Profissao> pesquisarId(Long id) {
        return profissaoFeignClient.pesquisarId(id);
    }

    public List<Profissao> pesquisaTodos() {
        return profissaoFeignClient.pesquisaTodos();
    }
}
