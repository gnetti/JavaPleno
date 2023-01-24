package rh.javapleno.pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.pagamento.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
