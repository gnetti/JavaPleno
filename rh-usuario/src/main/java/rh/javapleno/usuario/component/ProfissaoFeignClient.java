package rh.javapleno.usuario.component;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rh.javapleno.usuario.model.Profissao;
import java.util.List;

@FeignClient(name = "rh-pagamento", path = "/pagamento")
public interface ProfissaoFeignClient {


    @GetMapping(value = "/profissao/{id}")
    ResponseEntity<Profissao> pesquisarId(@PathVariable("id") Long id);

    @GetMapping(value = "/profissao")
    List<Profissao> pesquisaTodos();

}