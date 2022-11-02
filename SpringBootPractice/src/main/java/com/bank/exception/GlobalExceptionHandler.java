package com.bank.exception;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { StockNotFoundException.class })
	public ResponseEntity<?> handleStockNotFoundException(StockNotFoundException stockNotFoundException) {
		Map<String, String> message = new HashMap<>();
		message.put("timestamp", new Date().toString());
		message.put("error", stockNotFoundException.message);
		message.put("trace", "Stock not found, please enter correct id and check the path");
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

}
