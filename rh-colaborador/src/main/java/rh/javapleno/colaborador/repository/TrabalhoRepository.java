package rh.javapleno.colaborador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.colaborador.model.Trabalho;

import java.util.Optional;

public interface TrabalhoRepository extends JpaRepository <Trabalho, Long>{

    Optional<Trabalho> findById(Trabalho id);
}
