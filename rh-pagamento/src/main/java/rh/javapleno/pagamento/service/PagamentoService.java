package rh.javapleno.pagamento.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.Repository.PagamentoRepository;
import rh.javapleno.pagamento.component.EmailFeignClient;
import rh.javapleno.pagamento.enums.Situacao;
import rh.javapleno.pagamento.exceptions.PagamentoNaoEncontrado;
import rh.javapleno.pagamento.model.Email;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.model.dto.PagamentoDTO;
import rh.javapleno.pagamento.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final UsuarioService usuarioService;
    private final ProfissaoService profissaoService;
    private final EmailFeignClient emailFeignClient;

    public List<PagamentoDTO> pesquisaTodos() {
        List<Pagamento> pagamentoList = pagamentoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PagamentoDTO> pagamentoDTOS = new ArrayList<>();
        pagamentoList.forEach(pagamento -> {
            PagamentoDTO pagamentoDTO = new PagamentoDTO();
            pagamentoDTO.setId(pagamento.getId());
            pagamentoDTO.setNomeColaborador(usuarioService.pesquisarId(pagamento.getColaboradorId()).getBody().getNome());
            pagamentoDTO.setMatriculaColaborador(usuarioService.pesquisarId(pagamento.getColaboradorId()).getBody().getMatricula());
            pagamentoDTO.setColaboradorId(pagamento.getColaboradorId());
            pagamentoDTO.setData(pagamento.getData());
            pagamentoDTO.setValorDia(pagamento.getValorDia());
            pagamentoDTO.setSituacao(pagamento.getSituacao());
            pagamentoDTO.setStatus(pagamento.getStatus());
            pagamentoDTOS.add(pagamentoDTO);
        });

        return pagamentoDTOS;

    }

    public Pagamento salvar(Pagamento pagamento, Long id) {
        validaDataPagamentoAtual(id, pagamento.getData());
        ResponseEntity<Usuario> usuarioResponseEntity = usuarioService.pesquisarId(id);
        Optional<Profissao> profissaoOptional = profissaoService.pesquisarId(usuarioResponseEntity.getBody().getProfissaoId());
        pagamento.setColaboradorId(usuarioResponseEntity.getBody().getId());
        pagamento.setSituacao(Situacao.ATIVO);
        return pagamentoRepository.save(pagamento);

    }

    public Pagamento salvarParaColaborador(Pagamento pagamento, Long id) {
        validaDataPagamentoAtual(id, pagamento.getData());
        ResponseEntity<Usuario> usuario = usuarioService.pesquisarId(id);
        Optional<Profissao> profissao = profissaoService.pesquisarId(usuario.getBody().getProfissaoId());
        pagamento.setColaboradorId(usuario.getBody().getId());
        pagamento.setSituacao(Situacao.ATIVO);
        Pagamento pagamentoModel = pagamentoRepository.save(pagamento);

        Email email = Email.builder()
                .emailTo("luizerytre@gmail.com")
                .emailFrom("answer.buffetfenix@gmail.com")
                .subject("Buffet Fenix")
                .text("Olá, " + usuario.getBody().getNome()
                        + " fez um lançamento de diária, "
                        + "e aguarda sua aprovação!")
                .build();
        try {
            emailFeignClient.enviar(email);
        } catch (RuntimeException e) {
            log.error("{}", e);
        }

        return pagamentoModel;

    }

    public ResponseEntity<List<PagamentoDTO>> pesquisarColId(Long id) {
        try {
            List<Pagamento> pagamentoList = pagamentoRepository.findByColaboradorIdAndSituacaoOrderByIdDesc(id, Situacao.ATIVO);
            List<PagamentoDTO> pagamentoDTOS = new ArrayList<>();
            pagamentoList.forEach(pagamento -> {
                PagamentoDTO pagamentoDTO = new PagamentoDTO();
                pagamentoDTO.setId(pagamento.getId());
                pagamentoDTO.setNomeColaborador(usuarioService.pesquisarId(pagamento.getColaboradorId()).getBody().getNome());
                pagamentoDTO.setMatriculaColaborador(usuarioService.pesquisarId(pagamento.getColaboradorId()).getBody().getMatricula());
                pagamentoDTO.setColaboradorId(pagamento.getColaboradorId());
                pagamentoDTO.setData(pagamento.getData());
                pagamentoDTO.setValorDia(pagamento.getValorDia());
                pagamentoDTO.setSituacao(pagamento.getSituacao());
                pagamentoDTO.setStatus(pagamento.getStatus());
                pagamentoDTOS.add(pagamentoDTO);
            });
            return ResponseEntity.ok(pagamentoDTOS);
        } catch (RuntimeException e) {
            log.error("Erro na colsulta", e);
        }
        return ResponseEntity.noContent().build();
    }

    public Pagamento alterarSituacao(Long id, Situacao situacao) {
        Pagamento pagamentoEntity = pagamentoRepository.findById(id).orElseThrow();
        pagamentoEntity.setSituacao(situacao);
        return pagamentoRepository.save(pagamentoEntity);
    }

    public Pagamento alterarStatus(Long id, char status) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
        pagamento.setStatus(status);
        Pagamento pagamentoModel = pagamentoRepository.save(pagamento);
        return pagamentoModel;
    }

    public Pagamento pesquisarIdLan(Long id) {

        return pagamentoRepository.findById(id).orElseThrow(() -> new PagamentoNaoEncontrado("Pagamento não encontrado!"));
    }

    public Pagamento alterar(Pagamento pagamento) {
        validaPagamento(pagamento);
        return pagamentoRepository.save(pagamento);
    }

    private void validaPagamento(Pagamento pagamento) {
        if (pagamento.getId() != null) {
            pesquisarIdLan(pagamento.getId());
        } else {
            throw new PagamentoNaoEncontrado("Pagamento não encontrado!");
        }
    }

    private void validaDataPagamentoAtual(Long colaboradorId, LocalDate data) {
        if (comparaData(colaboradorId, data)) {
            throw new RuntimeException("Já existe um lançamento com esta data!");
        }
    }

    private boolean comparaData(Long colaboradorId, LocalDate data) {
        return pagamentoRepository
                .findByColaboradorIdAndSituacao(colaboradorId, Situacao.ATIVO)
                .stream()
                .anyMatch(pagamento -> pagamento
                        .getData().equals(data));
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public List<Pagamento> pesquisarPorData(LocalDate dataInicio, LocalDate dataFim) {
        if (dataInicio != null && dataFim != null ) {
            return pagamentoRepository.findByDataBetween(dataInicio, dataFim);
        } else {
            throw new PagamentoNaoEncontrado("Pagamento não encontrado!");
        }

    }
}
