package rh.javapleno.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
//public class HrConfigServerApplication implements CommandLineRunner {
public class RhServer {

//	@Value("${spring.cloud.config.server.git.username}")
//	private String username;
	
	public static void main(String[] args) {
		SpringApplication.run(RhServer.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		//System.out.println("USERNAME = " + username);
//	}
}
