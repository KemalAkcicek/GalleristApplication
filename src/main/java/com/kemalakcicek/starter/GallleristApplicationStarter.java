package com.kemalakcicek.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.kemalakcicek" })
@EnableJpaRepositories(basePackages = { "com.kemalakcicek" })
@ComponentScan(basePackages = { "com.kemalakcicek" })
public class GallleristApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(GallleristApplicationStarter.class, args);
	}

}
