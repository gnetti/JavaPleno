package rh.javapleno.usuario.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        Usuario usuarioModel = usuarioRepository.save(usuario);
        return usuarioModel;
    }

    public List<Usuario> pesquisaTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> pesquisarId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void deletar(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public void alterar(Usuario usuario) {
        Usuario usuarioEntity = usuarioRepository.findById(usuario.getId()).orElseThrow();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioRepository.save(usuario);
    }

    public ResponseEntity<Usuario> pesquisarEmail(String email) {
        try {

            Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

            return ResponseEntity.ok(usuario.get()); // status code 200 com um body
        } catch (RuntimeException e) {
            log.error("erro na colsulta {}", e);
        }
        return ResponseEntity.noContent().build(); // status code 500
    }
}


