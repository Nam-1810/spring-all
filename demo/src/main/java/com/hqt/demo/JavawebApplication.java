package com.hqt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@ImportResource(locations = {"classpath:repository-bean.xml", "classpath:WebFlowConfigXml.xml"})
@ComponentScan(basePackages={"com.hqt.demo"})
public class JavawebApplication {
	
	public static void main(String[] args) {
	
		SpringApplication.run(JavawebApplication.class, args);
	}

}
