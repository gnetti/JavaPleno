package rh.javapleno.usuario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rh.javapleno.usuario.model.Role;
import rh.javapleno.usuario.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role salvar(Role role) {
        Role roleModel = roleRepository.save(role);
        return roleModel;
    }

    public void alterar(Role role) {
        Role roleEntity = roleRepository.findById(role.getId()).orElseThrow();
        roleEntity.setRoleName(role.getRoleName());
        roleRepository.save(role);
    }

    public void deletar(Long id) {
        try {
            roleRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public List<Role> pesquisaTodos() {
        return roleRepository.findAll();
    }

    public Optional<Role> pesquisarId(Long id) {
        return roleRepository.findById(id);
    }

}
