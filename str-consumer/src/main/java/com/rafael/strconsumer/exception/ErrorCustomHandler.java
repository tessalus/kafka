package com.rafael.strconsumer.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

	private static final Logger log = LogManager.getLogger(ErrorCustomHandler.class);	
	
	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION_HANDLER ::: Capturei um erro");
		return null;
	}

}
