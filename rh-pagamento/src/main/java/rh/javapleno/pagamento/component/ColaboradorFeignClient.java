package rh.javapleno.pagamento.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rh.javapleno.pagamento.model.Colaborador;


@FeignClient(name = "rh-colaborador", path = "/colaborador")
public interface ColaboradorFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Colaborador> pesquisarId(@PathVariable("id") Long id);
}
