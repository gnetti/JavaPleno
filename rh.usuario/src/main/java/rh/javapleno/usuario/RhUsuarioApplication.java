package rh.javapleno.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RhUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhUsuarioApplication.class, args);
	}

}
