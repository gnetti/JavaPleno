package rh.javapleno.usuario.repository;

import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rh.javapleno.usuario.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);

    @Query(" select u from Usuario u where u.nome like %:nome% and u.colaborador=1")
    List<Usuario> findByNomeLike(@Param("nome") String nome);

    @Query(" select u from Usuario u where u.colaborador=1")
    List<Usuario> findAllColaborador();

   }
