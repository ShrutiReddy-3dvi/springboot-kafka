package com.kafka.producer.service;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublisherService.class);

	@Value("${topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Integer> kafkaTemplate;

	public Boolean publishMessage() {
		Boolean result = false;
		Random randomNumbers = new Random();

		Integer message = randomNumbers.nextInt(1000);
		/*
		 * IntStream stream=new Random().ints(0, 1000).limit(5); int[]
		 * message=stream.distinct().sorted().toArray();
		 */

		LOGGER.info("sending message='{}'", message);

		try {
			kafkaTemplate.send(topicName, message);
			result = true;
		} catch (Exception e) {
			LOGGER.error("message sending failed  " + e.getMessage());
		}

		return result;
	}
}
