package com.rafael.strproducer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.strproducer.services.StringProducerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {
	
	@Autowired
	private StringProducerService producerService;
	
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody String message){
		producerService.sendMessage(message);				
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}


}
