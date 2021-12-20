package com.hqt.demo.kafka;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;

public class KTableDemo {
	public static void main(String[] args) throws IOException {
		final Properties properties = new Properties();
		FileInputStream is = new FileInputStream("ss");
		properties.load(is);
		final Serde<String> stringSerde = Serdes.String();

		StreamsBuilder builder = new StreamsBuilder();
		
		Materialized.<String, String, KeyValueStore<Bytes, byte[]>>as("counts");
		KTable<String, String> kb = builder.table("topic", Materialized.with(stringSerde, stringSerde));
			kb.filter((key, value) -> value.contains("text"))
				.mapValues(value -> value.substring(0,5))
				.filter((key, value) -> Long.parseLong(value) > 1000)
				.toStream().to("streams-wordcount-output", Produced.with(stringSerde, stringSerde));
	}
}
