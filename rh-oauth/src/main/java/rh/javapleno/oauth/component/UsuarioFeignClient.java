package rh.javapleno.oauth.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rh.javapleno.oauth.model.Usuario;

@Component
@FeignClient(name = "rh-usuario", path = "/usuario")
public interface UsuarioFeignClient {

	@GetMapping(value = "/busca")
	ResponseEntity<Usuario> findByEmail(@RequestParam String email);
}
