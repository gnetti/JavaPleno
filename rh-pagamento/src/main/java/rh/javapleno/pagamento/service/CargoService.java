package rh.javapleno.pagamento.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.pagamento.Repository.CargoRepository;
import rh.javapleno.pagamento.model.Cargo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    public Cargo salvar(Cargo cargo) {
        Cargo roleModel = cargoRepository.save(cargo);
        return roleModel;
    }

    public void alterar(Cargo cargo) {
        Cargo cargoEntity = cargoRepository.findById(cargo.getId()).orElseThrow();
        cargoEntity.setDescricaoCargo(cargo.getDescricaoCargo());
        cargoEntity.setValorDia(cargo.getValorDia());
        cargoRepository.save(cargo);
    }

    public void deletar(Long id) {
        try {
            cargoRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public List<Cargo> pesquisaTodos() {
        return cargoRepository.findAll();
    }


    public Optional<Cargo> pesquisarId(Long id) {
        return cargoRepository.findById(id);
    }
}
