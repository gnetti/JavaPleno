package rh.javapleno.pagamento.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rh.javapleno.pagamento.model.Colaborador;


@Component
@FeignClient(name = "rh-colaborador", path = "/colaborador")
public interface ColaboradorFeignClientComponent {

    @GetMapping(value = "/{id}")
    ResponseEntity<Colaborador> findById(@PathVariable Long id);
}
