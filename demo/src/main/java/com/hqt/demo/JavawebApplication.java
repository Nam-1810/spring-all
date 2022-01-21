package com.hqt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:*.xml"})
@ComponentScan(basePackages={"com.hqt.demo"})
public class JavawebApplication {
	
	public static void main(String[] args) {
	
		SpringApplication.run(JavawebApplication.class, args);
	}

}
