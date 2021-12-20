package com.hqt.demo.kafka;

import java.util.HashMap;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

@Configuration
@EnableKafkaStreams
public class KafkaStreamConfig {

	@Value(value = "${monitor.kafka.bootstrap.config}")
	private String bootstrapAddress;

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kafkastreamconfig() {

		HashMap<String, Object> props = new HashMap<String, Object>();

		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "spring-boot-streams");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

		return new KafkaStreamsConfiguration(props);

	}

}
