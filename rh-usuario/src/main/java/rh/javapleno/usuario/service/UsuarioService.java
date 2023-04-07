package rh.javapleno.usuario.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import rh.javapleno.usuario.component.EmailFeignClient;
import rh.javapleno.usuario.enums.Situacao;
import rh.javapleno.usuario.exceptions.UsuarioNaoEncontrado;
import rh.javapleno.usuario.model.Email;
import rh.javapleno.usuario.model.Endereco;
import rh.javapleno.usuario.model.Role;
import rh.javapleno.usuario.model.Usuario;
import rh.javapleno.usuario.model.dto.UsuarioDTO;
import rh.javapleno.usuario.repository.UsuarioRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final EnderecoService enderecoService;
    private final EmailFeignClient emailFeignClient;

    private String generateRandomPassword(int senha) {
        return RandomStringUtils.randomAlphanumeric(senha);
    }

    private String geraMatricula(String matricula) {
        return matricula.substring(0, 9);
    }

    public Usuario salvar(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();

        if (!ObjectUtils.isEmpty(cep)) {
            Endereco endereco = enderecoService.getEndereco(cep);
            usuario.getEndereco().setRua(endereco.getRua());
            usuario.getEndereco().setBairro(endereco.getBairro());
            usuario.getEndereco().setCidade(endereco.getCidade());
            usuario.getEndereco().setUf(endereco.getUf());
        }
        int senha = 10;
        String senhaGerada = generateRandomPassword(senha);
        String senhaCriptrografada = passwordEncoder.encode(senhaGerada);
        usuario.setPassword(senhaCriptrografada);
        usuario.setSituacao(Situacao.ATIVO);

        String matriculaGerada = geraMatricula(usuario.getCpf());
        usuario.setMatricula("BR" + matriculaGerada);

        if (isColaborador(usuario.getRoles()))
            usuario.setPrimeiroAcesso(Boolean.TRUE);
        else
            usuario.setPrimeiroAcesso(Boolean.FALSE);

        Usuario usuarioModel = usuarioRepository.save(usuario);

        Email email = Email.builder()
                .emailTo(usuario.getEmail())
                .emailFrom("answer.buffetfenix@gmail.com")
                .subject("Buffet Fenix")
                .text("Seja bem vindo " + usuario.getNome() + ", "
                        + "  Login: " + " " + usuario.getEmail()
                        + " " + " Senha: " + senhaGerada
                        + " " + " importante trocar sua senha no primeiro acesso! ")
                .build();
        try {
            emailFeignClient.enviar(email);
        } catch (RuntimeException e) {
            log.error("{}", e);
        }
        return usuarioModel;
    }


    public void deletar(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new UsuarioNaoEncontrado("O usuário informado não existe");
        }
    }

    public Usuario alterar(Usuario usuario) {
        if (usuario.getId() == null)
            throw new UsuarioNaoEncontrado("É nescessário informar um id do usuário para atualizar.");
        Usuario usuarioBD = pesquisarId(usuario.getId());

        if (usuario.getPassword() == null ||
                Boolean.TRUE.equals(validaSenhaUsuario(usuarioBD.getPassword(), encode(usuario.getPassword()))))
            usuario.setPassword(usuarioBD.getPassword());
        else
            usuario.setPassword(encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> pesquisaTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new ModelMapper().map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public Usuario pesquisarId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new UsuarioNaoEncontrado("O usuário informado não existe"));
    }

    public ResponseEntity<Usuario> pesquisarEmail(String email) {
        try {
            Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(email));
            return ResponseEntity.ok(usuario.get());
            //  return usuario.get();
        } catch (RuntimeException e) {
            //log.error("Erro na colsulta", e);
            new UsuarioNaoEncontrado("Usuário não Encontrado");

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

    public List<UsuarioDTO> pesquisaTodosColaborador() {
        return usuarioRepository.findAllColaborador()
                .stream()
                .map(u -> new ModelMapper().map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public List<Usuario> pesquisaNome(String nome) {
        List<Usuario> usuario = usuarioRepository.findByNomeLikeColaborador(nome);
        return usuario;
    }


    public Usuario pesquisarIdColaborador(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findByIdAndColaboradorAndSituacao(id, '1', Situacao.ATIVO);
        return usuario.orElseThrow(() -> new UsuarioNaoEncontrado("O colaborador informado não existe"));
    }


    public Usuario pesquisarEmailColaborador(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndColaboradorAndSituacao(email, '1', Situacao.ATIVO);
        return usuario.orElseThrow(() -> new UsuarioNaoEncontrado("O colaborador informado não existe"));
    }

    public ResponseEntity<Optional<Usuario>> pesquisarLogin(String email) {
        try {
            Optional<Optional<Usuario>> usuario = Optional.ofNullable(usuarioRepository.findByEmailAndSituacao(email, Situacao.ATIVO));
            return ResponseEntity.ok(usuario.get());

        } catch (RuntimeException e) {

            new UsuarioNaoEncontrado("Usuário não Encontrado");

        }
        return ResponseEntity.noContent().build();

    }

    public Usuario pesquisarEmailLogin(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndSituacao(email, Situacao.ATIVO);
        return usuario.orElseThrow(() -> new UsuarioNaoEncontrado("O usuário informado não existe"));
    }

    @Transactional
    public void atualizaSenha(Long id, String password) {
        try {
            usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontrado("O usuário informado não existe"));
            usuarioRepository.updateSenha(id, encode(password), Boolean.FALSE);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao alterar a senha.");
        }
    }

    public Boolean isColaborador(Set<Role> roles) {
        return roles.stream().anyMatch(r -> r.getRoleName().equals("ROLE_COLABORADOR"));
    }

}
