package com.example.electronic_store;

import com.example.electronic_store.constant.UserRole;
import com.example.electronic_store.dto.request.SignUpDto;
import com.example.electronic_store.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebSecurity
@RequiredArgsConstructor
public class ElectronicStoreApplication {
	private final AuthService authService;

	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner signUpNewUsers() {
		return (args) -> {
			SignUpDto user = new SignUpDto("Trinh Pham", "trinh.pham", "trinh.pham1234", UserRole.ADMIN);
			SignUpDto user2 = new SignUpDto("Ngoc Tran", "ngoc.tran", "ngoc.tran1234", UserRole.USER);
			SignUpDto user3 = new SignUpDto("Lan Nguyen", "lan.nguyen", "lan.nguyen1234", UserRole.USER);
			SignUpDto user4 = new SignUpDto("Han Pham", "han.pham", "han.pham1234", UserRole.USER);
			authService.signUp(user);
			authService.signUp(user2);
			authService.signUp(user3);
			authService.signUp(user4);
		};
	}
}