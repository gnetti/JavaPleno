package rh.javapleno.pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.pagamento.model.Pagamento;

public interface PagamentoRepository  extends JpaRepository<Pagamento, Long> {

}
