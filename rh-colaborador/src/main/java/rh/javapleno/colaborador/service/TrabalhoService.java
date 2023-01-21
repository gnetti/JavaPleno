package rh.javapleno.colaborador.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.colaborador.model.Trabalho;
import rh.javapleno.colaborador.repository.TrabalhoRepository;

@Service
@RequiredArgsConstructor
public class TrabalhoService {

    private final TrabalhoRepository trabalhoRepository;

    public Trabalho salvar(Trabalho trabalho) {
        return trabalhoRepository.save(trabalho);
    }


}
