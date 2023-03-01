package rh.javapleno.colaborador.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rh.javapleno.colaborador.model.Profissao;
import rh.javapleno.colaborador.model.Usuario;

import java.util.List;


@FeignClient(name = "rh-usuario", path = "/usuario")
public interface UsuarioFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Usuario> pesquisarId(@PathVariable("id") Long id);



    @GetMapping(value = "/profissao")
    List<Profissao> pesquisaTodos();

}
