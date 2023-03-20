package rh.javapleno.colaborador.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.colaborador.model.Profissao;
import rh.javapleno.colaborador.model.dto.PagamentoDTO;

import java.util.List;


@FeignClient(name = "rh-pagamento", path = "/pagamento")
public interface PagamentoFeignClient {

    @GetMapping(value = "/profissao/{id}")
    ResponseEntity<Profissao> pesquisarId(@PathVariable("id") Long id);

    @GetMapping(value = "/busca/{id}")
    ResponseEntity<List<PagamentoDTO>> pesquisarColId(@PathVariable Long id);

  }
