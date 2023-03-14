package rh.javapleno.colaborador.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rh.javapleno.colaborador.model.Profissao;

import java.util.List;


@FeignClient(name = "rh-pagamento", path = "/pagamento")
public interface ProfissaoFeignClient {

    @GetMapping(value = "/profissao/{id}")
    ResponseEntity<Profissao> pesquisarId(@PathVariable("id") Long id);



    @GetMapping
    ResponseEntity<Profissao> pesquisarTodos();
     
}
