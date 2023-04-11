package rh.javapleno.pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.enums.Situacao;

import java.time.LocalDate;
import java.util.List;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByColaboradorIdAndSituacaoOrderByIdDesc(Long id, Situacao situacao);

    List<Pagamento> findByColaboradorIdAndSituacao(Long colaboradorId, Situacao situacao);

    List<Pagamento> findByColaboradorIdAndDataBetweenAndSituacaoAndStatusOrderByDataAsc(Long id, LocalDate dataInicio, LocalDate dataFim, Situacao situacao, char status);
}
