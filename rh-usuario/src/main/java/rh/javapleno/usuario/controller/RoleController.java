package rh.javapleno.usuario.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.model.Role;
import rh.javapleno.usuario.service.RoleService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Tag(name = "Role")
public class RoleController {

    private final RoleService roleService;


    @Operation(summary = "Cadastro de role.")
    @PostMapping
    public Role salvar(@RequestBody Role role) {

        return roleService.salvar(role);
    }

    @Operation(summary = "Atualiza role.")
    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Role role) {
        roleService.alterar(role);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Deleta role por ID.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        roleService.deletar(id);
    }


    @Operation(summary = "Busca todas as roles.")
    @GetMapping
    public List<Role> PesquisaTodos() {
        return roleService.pesquisaTodos();
    }

    @Operation(summary = "Busca role por ID.")
    @GetMapping("{id}")
    public Optional<Role> pesquisarId(@PathVariable Long id) {

        return roleService.pesquisarId(id);
    }

}
