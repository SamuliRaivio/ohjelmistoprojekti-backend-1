package com.example.ohjelmistoprojektiBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ohjelmistoprojektiBackend.domain.Kysymys;
import com.example.ohjelmistoprojektiBackend.domain.KysymysRepository;


@SpringBootApplication
public class OhjelmistoprojektiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OhjelmistoprojektiBackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner test( KysymysRepository kysymysrepository) {
		return (args) -> {


			kysymysrepository.save(new Kysymys("teksti", "Kelpaako tämä kysymys?"));
			kysymysrepository.save(new Kysymys("radio", "Entäs tämä?"));
			
			//kyselyrepository.save(new Kysely("Kysely 1", (List<Kysymys>) kysymysrepository.findAll()));
		};
	}
	
}
