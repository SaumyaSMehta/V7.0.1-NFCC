package com.codingfreaks.NiagaraFallsCurlingClub;

import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class NiagaraFallsCurlingClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiagaraFallsCurlingClubApplication.class, args);
	}
}
