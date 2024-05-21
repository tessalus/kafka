package com.rafael.strproducer.services;

import java.lang.annotation.Annotation;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StringProducerService {

	private static final Logger log = LogManager.getLogger(StringProducerService.class);
	
	@Qualifier("kafkaTemplate")
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", message);
		
        future.whenComplete((success, ex) -> {
        	        	 
	            if (ex != null) {
	                log.error("Error sending message: {}", ex.getMessage());
	                return;
	            }
	            
	            log.info("Message sent successfully: {}", success.getProducerRecord().value());
	            log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
	        }
        );
        
	}
	
}
