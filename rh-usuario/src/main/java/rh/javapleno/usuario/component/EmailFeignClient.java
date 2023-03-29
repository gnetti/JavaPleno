package rh.javapleno.usuario.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import rh.javapleno.usuario.model.Email;


@FeignClient(name = "rh-email", path = "/email")
public interface EmailFeignClient {

    @PostMapping
    Email enviar(Email email);

    }
