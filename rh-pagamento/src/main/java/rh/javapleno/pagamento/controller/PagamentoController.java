package rh.javapleno.pagamento.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.pagamento.model.Pagamento;
import rh.javapleno.pagamento.model.Profissao;
import rh.javapleno.pagamento.model.Usuario;
import rh.javapleno.pagamento.service.PagamentoService;
import rh.javapleno.pagamento.service.ProfissaoService;
import rh.javapleno.pagamento.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    private final UsuarioService usuarioService;
    private final ProfissaoService profissaoService;

    @GetMapping("/profissao/{id}")
    public Optional<Profissao> pesquisarIdPro(@PathVariable Long id) {

        return profissaoService.pesquisarId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id) {
        return usuarioService.pesquisarId(id);
    }

    @PostMapping("/{id}")

    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento, @PathVariable Long id) {
        ResponseEntity<Usuario> usuarioResponseEntity = pesquisarId(id);
        pagamento.setColaboradorId(usuarioResponseEntity.getBody().getId());
        Optional<Profissao> profissaoOptional = pesquisarIdPro(id);
        pagamento.setValorDia(profissaoOptional.orElseThrow().getValorDia());
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.salvar(pagamento));
    }
    @GetMapping(value = "/busca/{id}")
    public ResponseEntity <List<Pagamento>> pesquisarColId(@PathVariable  Long id) {
        ResponseEntity<Usuario> usuarioResponseEntity = pesquisarId(id);
        return pagamentoService.pesquisarColId(id);
    }
}
