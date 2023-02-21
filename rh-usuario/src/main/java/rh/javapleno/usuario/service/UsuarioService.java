package rh.javapleno.usuario.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.model.dto.UsuarioDTO;
import rh.javapleno.usuario.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario) {
        Usuario usuarioModel = usuarioRepository.save(usuario);
        return usuarioModel;
    }

    public Usuario alterar(Usuario usuario) {

        if(usuario.getId() == null)
            throw new RuntimeException("É nescessário informar um id do usuário para atualizar.");

        Usuario usuarioBD = pesquisarId(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (usuario.getPassword() == null ||
                Boolean.TRUE.equals(validaSenhaUsuario(usuarioBD.getPassword(), encode(usuario.getPassword()))))
            usuario.setPassword(usuarioBD.getPassword());
        else
            usuario.setPassword(encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public List<UsuarioDTO> pesquisaTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new ModelMapper().map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<Usuario> pesquisarId(Long id) {
        return usuarioRepository.findById(id);
    }

    public ResponseEntity<Usuario> pesquisarEmail(String email) {
        try {
            Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(email));
            return ResponseEntity.ok(usuario.get());
        } catch (RuntimeException e) {
            log.error("Erro na colsulta", e);
        }
        return ResponseEntity.noContent().build();
    }

    private Boolean validaSenhaUsuario(String passwordAtual, String passwordNova) {
        return passwordAtual.equals(passwordNova);
    }

    private String encode(String password) {
        return passwordEncoder.encode(password);
    }

    public Object pesquisarEmailNome(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
