package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.constants.ApiPathConstants;

@SpringBootApplication
@RestController
public class SpringbootKafkaConsumerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootKafkaConsumerApplication.class);
	Integer topicMessage;

	@GetMapping(ApiPathConstants.GET_MESSAGE_URL)
	public Integer consumeMessage() {
		return topicMessage;
	}

	@KafkaListener(topics = "test_topic", groupId = "userGroup")
	public Integer getMessageFromTopic(Integer message) {
		this.topicMessage = message;
		LOGGER.info("received message='{}'", topicMessage);
		return topicMessage;

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaConsumerApplication.class, args);

	}

}
