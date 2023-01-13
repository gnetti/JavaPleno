package rh.javapleno.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.javapleno.usuario.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role, Long> {

    Optional<Role> findById(Long id);
}
