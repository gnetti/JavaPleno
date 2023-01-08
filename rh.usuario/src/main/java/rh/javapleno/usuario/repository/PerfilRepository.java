package rh.javapleno.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.usuario.model.Perfil;
import rh.javapleno.usuario.model.Usuario;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findById(Long id);

}
