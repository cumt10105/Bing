package com.example.demo;

import com.example.demo.spring.domain.Journal;
import com.example.demo.spring.domain.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Bean
	InitializingBean saveData(JournalRepository repo){
		return ()->{
			repo.deleteAll();
			repo.save(new Journal("Get to know Spring Boot1","Today I will learn Spring Boot","01/01/2016"));
			repo.save(new Journal("Simple Spring Boot Project2","I will do my first Spring Boot Project","01/02/2016"));
			repo.save(new Journal("Spring Boot Reading3","Read more about Spring Boot","02/01/2016"));
			repo.save(new Journal("Spring Boot in the Cloud4","Spring Boot using Cloud Foundry","03/01/2016"));
		};
	}

	@Override//为了打包springboot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
