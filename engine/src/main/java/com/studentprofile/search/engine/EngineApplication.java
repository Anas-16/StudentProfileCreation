package com.studentprofile.search.engine;

import com.studentprofile.search.engine.service.StudentOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EngineApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EngineApplication.class, args);
		StudentOptions studentOptions = context.getBean(StudentOptions.class);
		studentOptions.switchStatements();
		context.close();
	}

}
