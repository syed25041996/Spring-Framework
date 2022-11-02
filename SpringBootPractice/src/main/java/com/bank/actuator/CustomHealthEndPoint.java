package com.bank.actuator;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom-health")
public class CustomHealthEndPoint {

	static Map<String, String> message = new HashMap<String, String>();

	@PostConstruct
	public Map<String, String> getBugs() {

		message.put("v1", "Browser is closing");
		message.put("v2", "Tab not opening");

		return message;
	}

	@ReadOperation
	public Map<String, String> getMessage() {
		// writing a random message for a endpoint
		return getBugs();
	}

	@WriteOperation
	public Map<String, String> sendMessage(@Selector String version, String arg) {
		// read a message
		message.put(version, arg);

		return message;
	}

	@DeleteOperation
	public void deleteMessage(@Selector String version) {
		// delete the message
		message.remove(version);
	}
}