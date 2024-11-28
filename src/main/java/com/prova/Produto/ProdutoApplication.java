package com.prova.Produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages =  "com.prova.Produto")
@EntityScan(basePackages = {"com.prova.Produto.domains", "com.prova.Produto.domains.enums"})
@EnableJpaRepositories(basePackages =  "com.prova.Produto.repositories")
@SpringBootApplication
public class ProdutoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProdutoApplication.class, args);
	}

}
