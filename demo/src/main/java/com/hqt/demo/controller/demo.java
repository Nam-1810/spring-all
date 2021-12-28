package com.hqt.demo.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class demo {

	@KafkaListener(topics = { "hobbit" }, groupId = "admin")
	public void hobbit(String message) {
		System.out.println("Hobbit say: " + message);

	}

	@KafkaListener(topics = { "streams-wordcount-output" }, groupId = "spring-boot-kafka")
	public void consume(ConsumerRecord<String, Long> record) {
		System.out.println("received = " + record.value() + " with key " + record.key());
	}

}
