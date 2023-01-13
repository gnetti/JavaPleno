package rh.javapleno.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rh.javapleno.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
}
