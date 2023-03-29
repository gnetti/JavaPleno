package rh.javapleno.pagamento.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import rh.javapleno.pagamento.model.Email;


@FeignClient(name = "rh-email", path = "/email")
public interface EmailFeignClient {

    @PostMapping
    Email enviar(Email email);

    }
