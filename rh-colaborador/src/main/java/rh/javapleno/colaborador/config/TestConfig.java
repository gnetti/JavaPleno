package rh.javapleno.colaborador.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import rh.javapleno.colaborador.service.DBService;

@Configuration
//@Profile("dev")
public class TestConfig {

    @Autowired
    private DBService dbService;

//    @Bean
//    public void startDB() {
//        this.dbService.startDB();
//    }
}
