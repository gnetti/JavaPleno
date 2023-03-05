package rh.javapleno.pagamento.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.Repository.PagamentoRepository;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.model.Situacao;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.model.dto.PagamentoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final UsuarioService usuarioService;
    private final ProfissaoService profissaoService;

    public List<PagamentoDTO> pesquisaTodos() {
        List<Pagamento> pagamentoList = pagamentoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PagamentoDTO> pagamentoDTOS = new ArrayList<>();
        pagamentoList.forEach(pagamento -> {
            PagamentoDTO pagamentoDTO = new PagamentoDTO();
            pagamentoDTO.setId(pagamento.getId());
            pagamentoDTO.setNomeColaborador(usuarioService.pesquisarId(pagamento.getColaboradorId()).getBody().getNome());
            pagamentoDTO.setColaboradorId(pagamento.getColaboradorId());
            pagamentoDTO.setData(pagamento.getData());
            pagamentoDTO.setValorDia(pagamento.getValorDia());
            pagamentoDTO.setSituacao(Situacao.ATIVO);
            pagamentoDTOS.add(pagamentoDTO);
        });

        return pagamentoDTOS;

    }

    public Pagamento salvar(Pagamento pagamento, Long id) {
        ResponseEntity<Usuario> usuarioResponseEntity = usuarioService.pesquisarId(id);
        Optional<Profissao> profissaoOptional = profissaoService.pesquisarId(usuarioResponseEntity.getBody().getProfissaoId());
        pagamento.setColaboradorId(usuarioResponseEntity.getBody().getId());
        pagamento.setValorDia(profissaoOptional.orElseThrow().getValorDia());
        pagamento.setSituacao(Situacao.ATIVO);
        return pagamentoRepository.save(pagamento);
    }

    public ResponseEntity<List<Pagamento>> pesquisarColId(Long id) {
        try {
            List<Pagamento> pagamento = (pagamentoRepository.findByColaboradorId(id));
            return ResponseEntity.ok(pagamento);
        } catch (RuntimeException e) {
            log.error("Erro na colsulta", e);
        }
        return ResponseEntity.noContent().build();
    }
}
