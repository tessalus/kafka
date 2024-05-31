package com.rafael.strconsumer.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.rafael.strconsumer.custom.StrConsumerCustomListener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

	private static final Logger log = LogManager.getLogger(StrConsumerListener.class);
	
	@SneakyThrows
	@StrConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: message {}", message);
		throw new IllegalArgumentException("EXCEPTION ... ");
	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: message {}", message);
	}	
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: message {}", message);
	}	
	
}
