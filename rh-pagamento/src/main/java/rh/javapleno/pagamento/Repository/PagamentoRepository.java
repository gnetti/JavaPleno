package rh.javapleno.pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Situacao;

import java.util.List;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByColaboradorId(Long id);

    List<Pagamento> findByStatusAndSituacaoOrderByIdDesc(char status, Situacao situacao);
}
