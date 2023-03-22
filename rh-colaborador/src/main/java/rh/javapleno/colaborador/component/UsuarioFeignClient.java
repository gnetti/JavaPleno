package rh.javapleno.colaborador.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import rh.javapleno.colaborador.model.Profissao;
import rh.javapleno.colaborador.model.Usuario;
import rh.javapleno.colaborador.model.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "rh-usuario", path = "/usuario")
public interface UsuarioFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Usuario> pesquisarId(@PathVariable("id") Long id);



    @GetMapping(value = "/profissao")
    List<Profissao> pesquisaTodos();

    @GetMapping(value = "/colaborador/email")
    ResponseEntity<Optional<Usuario>> pesquisarEmail(@RequestParam String email);

    @GetMapping(value = "/colaborador/{id}")
    UsuarioDTO pesquisarIdColaborador(@PathVariable Long id);
}
