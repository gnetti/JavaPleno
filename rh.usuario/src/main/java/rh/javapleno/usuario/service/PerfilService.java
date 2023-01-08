package rh.javapleno.usuario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.usuario.model.Perfil;
import rh.javapleno.usuario.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PerfilService {

    private final PerfilRepository perfilRepository;

    public Perfil salvar(Perfil perfil) {
        Perfil perfilModel = perfilRepository.save(perfil);
        return perfilModel;
    }

    public List<Perfil> pesquisaTodos() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> pesquisarId(Long id) {
        return perfilRepository.findById(id);
    }

    public void deletar(Long id) {
        try {
            perfilRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public void alterar(Perfil perfil) {
        Perfil perfilEntity = perfilRepository.findById(perfil.getId()).orElseThrow();
        perfilEntity.setNomePerfil(perfil.getNomePerfil());
        perfilRepository.save(perfil);
    }

}
