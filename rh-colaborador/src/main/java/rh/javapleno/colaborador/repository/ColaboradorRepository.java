package rh.javapleno.colaborador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.colaborador.model.Colaborador;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Optional<Colaborador> findById(Long id);

}
