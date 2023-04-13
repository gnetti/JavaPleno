package rh.javapleno.pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import rh.javapleno.pagamento.enums.Situacao;
import rh.javapleno.pagamento.model.Pagamento;

import java.time.LocalDate;
import java.util.List;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByColaboradorIdAndSituacaoOrderByIdDesc(Long id, Situacao situacao);

    List<Pagamento> findByColaboradorIdAndSituacao(Long colaboradorId, Situacao situacao);

    List<Pagamento> findByColaboradorIdAndDataBetweenAndSituacaoAndStatusOrderByDataAsc(Long id, LocalDate dataInicio, LocalDate dataFim, Situacao situacao, char status);

    @Modifying
    @Query("update Pagamento p set p.status =?4 where p.colaboradorId =?1 and p.data between ?2 and ?3 ")
    void updateStatus(Long colaboradorId, LocalDate dataInicio, LocalDate dataFim, char status);
}
