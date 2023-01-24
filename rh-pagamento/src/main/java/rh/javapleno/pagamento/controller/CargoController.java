package rh.javapleno.pagamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.model.Cargo;
import rh.javapleno.pagamento.service.CargoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cargo")
public class CargoController {

    private final CargoService cargoService;

    @PostMapping
    public Cargo salvar(@RequestBody Cargo cargo) {

        return cargoService.salvar(cargo);
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Cargo cargo) {
        cargoService.alterar(cargo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        cargoService.deletar(id);
    }

    @GetMapping
    public List<Cargo> PesquisaTodos() {
        return cargoService.pesquisaTodos();
    }

    @GetMapping("{id}")
    public Optional<Cargo> pesquisarId(@PathVariable Long id) {
        return cargoService.pesquisarId(id);
    }

}

