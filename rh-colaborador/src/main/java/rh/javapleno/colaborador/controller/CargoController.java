package rh.javapleno.colaborador.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.javapleno.colaborador.model.Cargo;
import rh.javapleno.colaborador.service.CargoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final CargoService cargoService;

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> pesquisarId(@PathVariable Long id){
        return cargoService.pesquisarId(id);
    }

}
