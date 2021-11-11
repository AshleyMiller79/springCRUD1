package com.SpringCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //normalde bu alttakileri kapsıyor ama hocada alttakiler olmadan çalışmamış
@ComponentScan({"controller","service"})//aradığını bulabilsin diye package leri belirtiyorum. 
//temel olanlar bu şekilde (controller,service). model gibiler alttaki gibi
@EntityScan("model")
@EnableJpaRepositories("repository")
public class SpringCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
	
	
	
	
	
	
	
	
}
