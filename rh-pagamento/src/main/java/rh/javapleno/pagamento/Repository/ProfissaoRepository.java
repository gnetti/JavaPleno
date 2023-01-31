package rh.javapleno.pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.pagamento.model.Profissao;

public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {
}
