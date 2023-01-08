package rh.javapleno.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.usuario.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);

}
