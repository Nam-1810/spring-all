package com.hqt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.javafaker.Faker;

@Controller
public class hobbitSay {

	Faker faker;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/send_messager")
	public String generate() {

		faker = Faker.instance();

		kafkaTemplate.send("hobbit","hobit" + faker.random().nextInt(42), faker.hobbit().quote());

		return "redirect:/home";
	}

}
