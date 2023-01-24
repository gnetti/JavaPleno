package rh.javapleno.colaborador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.model.Colaborador;
import rh.javapleno.colaborador.repository.ColaboradorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public Colaborador salvar(Colaborador colaborador) {
        Colaborador colaboradorModel = colaboradorRepository.save(colaborador);
        return colaboradorModel;
    }

    public List<Colaborador> pesquisaTodos() {
        return colaboradorRepository.findAll();
    }

    public Optional<Colaborador> pesquisarId(Long id) {
        return colaboradorRepository.findById(id);
    }

    public void deletar(Long id) {
        try {
            colaboradorRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public void alterar(Colaborador colaborador) {
        Colaborador colaboradorEntity = colaboradorRepository.findById(colaborador.getId()).orElseThrow();
        colaboradorEntity.setNome(colaborador.getNome());
        colaboradorEntity.setCargoId(colaborador.getCargoId());
        colaboradorRepository.save(colaborador);
    }
}
