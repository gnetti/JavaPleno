package rh.javapleno.pagamento.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.Repository.ProfissaoRepository;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.enums.Situacao;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoRepository profissaoRepository;
    private final UsuarioService usuarioService;

    public Profissao salvar(Profissao profissao) {
        Profissao roleModel = profissaoRepository.save(profissao);
        return roleModel;
    }

    private void validaProficao(Long profissaoId, Situacao situacao) {
        if (situacao.equals(Situacao.INATIVO) && !usuarioService.findByProfissaoId(profissaoId).isEmpty())
            throw new RuntimeException("Esta profissão, está sendo utilizada em um cadastro de colaborador.");
    }

    public void alterar(Profissao profissao) {
        Profissao profissaoEntity = profissaoRepository.findById(profissao.getId()).orElseThrow();
        profissaoEntity.setDescricao(profissao.getDescricao());
        profissaoEntity.setValorDia(profissao.getValorDia());
        profissaoRepository.save(profissao);
    }

    public void deletar(Long id) {
        try {
            profissaoRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public List<Profissao> pesquisaTodos() {
        return profissaoRepository.findAll();
    }


    public Optional<Profissao> pesquisarId(Long id) {
        return profissaoRepository.findById(id);
    }

    public Profissao alterarSituacao(Long id, Situacao situacao) {
        validaProficao(id, situacao);
        Profissao pagamentoEntity = profissaoRepository.findById(id).orElseThrow();
        pagamentoEntity.setSituacao(situacao);
        return profissaoRepository.save(pagamentoEntity);
    }
}
