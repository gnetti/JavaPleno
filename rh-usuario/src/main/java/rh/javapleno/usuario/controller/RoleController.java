package rh.javapleno.usuario.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rh.javapleno.usuario.model.Role;
import rh.javapleno.usuario.service.RoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")

public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public Role salvar(@RequestBody Role role) {

        return roleService.salvar(role);
    }

    @PutMapping
    public ResponseEntity<Void> alterar(@RequestBody Role role) {
        roleService.alterar(role);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        roleService.deletar(id);
    }


    @GetMapping
    public List<Role> PesquisaTodos() {
        return roleService.pesquisaTodos();
    }

    @GetMapping("{id}")
    public Optional<Role> pesquisarId(@PathVariable Long id) {

        return roleService.pesquisarId(id);
    }

}
