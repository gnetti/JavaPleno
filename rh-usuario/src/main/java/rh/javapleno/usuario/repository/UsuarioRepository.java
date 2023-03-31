package rh.javapleno.usuario.repository;

import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import rh.javapleno.usuario.enums.Situacao;
import rh.javapleno.usuario.model.Usuario;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    @Query(" select u from Usuario u where u.nome like %:nome% and u.colaborador=1 and u.situacao=1")
    List<Usuario> findByNomeLikeColaborador(@Param("nome") String nome);

    @Query(" select u from Usuario u where u.colaborador=1 and u.situacao=1 order by u.nome asc")
    List<Usuario> findAllColaborador();

    Optional<Usuario> findByIdAndColaboradorAndSituacao(Long id, char colaborador, Situacao situacao);

    Optional<Usuario> findByEmailAndColaboradorAndSituacao(String email, char colaborador, Situacao situacao);

    Optional<Usuario> findByEmailAndSituacao(String email, Situacao situacao);

    @Modifying
    @Query("update Usuario u set u.password = ?2 where u.id = ?1")
    void updateSenha(Long id, String password);

}
