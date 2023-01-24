package rh.javapleno.colaborador.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rh.javapleno.colaborador.model.Cargo;


@FeignClient(name = "rh-pagamento", path = "/cargo")
public interface PagamentoFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Cargo> pesquisarId(@PathVariable("id") Long id);
}
