        package rh.javapleno.usuario.service;


        import lombok.RequiredArgsConstructor;
        import lombok.extern.log4j.Log4j2;
        import org.modelmapper.ModelMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Service;
        import rh.javapleno.usuario.exceptions.UsuarioNaoEncontrado;
        import rh.javapleno.usuario.model.Endereco;
        import rh.javapleno.usuario.model.Situacao;
        import rh.javapleno.usuario.model.Usuario;
        import rh.javapleno.usuario.model.dto.UsuarioDTO;
        import rh.javapleno.usuario.repository.UsuarioRepository;
        import java.util.List;
        import java.util.Optional;
        import java.util.stream.Collectors;
        import org.springframework.util.ObjectUtils;

        @Service
        @RequiredArgsConstructor
        @Log4j2
        public class UsuarioService {

            private final UsuarioRepository usuarioRepository;
            private final PasswordEncoder passwordEncoder;
            @Autowired
            private final EnderecoService enderecoService;
            public Usuario salvar(Usuario usuario) {
                String cep = usuario.getEndereco().getCep();

                if (!ObjectUtils.isEmpty(cep)) {
                    Endereco endereco = enderecoService.getEndereco(cep);
                    usuario.getEndereco().setRua(endereco.getRua());
                    usuario.getEndereco().setBairro(endereco.getBairro());
                    usuario.getEndereco().setCidade(endereco.getCidade());
                    usuario.getEndereco().setUf(endereco.getUf());
                }
                usuario.setSituacao(Situacao.ATIVO);
                Usuario usuarioModel = usuarioRepository.save(usuario);
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
                String cep = usuario.getEndereco().getCep();

                if(usuario.getId() == null)
                    throw new UsuarioNaoEncontrado("É nescessário informar um id do usuário para atualizar.");
                Usuario usuarioBD = pesquisarId(usuario.getId());

                if (usuario.getPassword() == null ||
                        Boolean.TRUE.equals(validaSenhaUsuario(usuarioBD.getPassword(), encode(usuario.getPassword()))))
                    usuario.setPassword(usuarioBD.getPassword());
                else
                    usuario.setPassword(encode(usuario.getPassword()));
                Endereco endereco = enderecoService.getEndereco(cep);
                usuario.setEndereco(endereco);
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
        }
