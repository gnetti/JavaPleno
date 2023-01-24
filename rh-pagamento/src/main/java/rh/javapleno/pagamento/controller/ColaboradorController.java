package rh.javapleno.pagamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.pagamento.model.Colaborador;
import rh.javapleno.pagamento.service.ColaboradorService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/colaborador")

public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> pesquisarId(@PathVariable Long id){
        return colaboradorService.pesquisarId(id);
    }

}
