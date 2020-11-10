package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.constants.ApiPathConstants;
import com.kafka.producer.exception.InternalServerException;
import com.kafka.producer.service.PublisherService;

@RestController
@RequestMapping(ApiPathConstants.BASE_URL)
public class PublisherController {
	final String SUCCESS_RESPONSE = "message published successfully";
	final String ERROR_RESPONSE = "500";
	Throwable TYPE = new Throwable("message sending failed");

	@Autowired
	private PublisherService publisherService;

	@GetMapping(ApiPathConstants.GET_MESSAGE_URL)
	public String publishMessage() {

		Boolean result = publisherService.publishMessage();
		if (result) {
			return SUCCESS_RESPONSE;
		} else {
			throw new InternalServerException(TYPE, ERROR_RESPONSE);
		}
	}
}
