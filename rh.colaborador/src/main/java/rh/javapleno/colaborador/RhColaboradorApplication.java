package rh.javapleno.colaborador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RhColaboradorApplication {


    public static void main(String[] args) {
        SpringApplication.run(RhColaboradorApplication.class, args);
    }


}
