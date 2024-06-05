package com.rafael.strconsumer.exception;

<<<<<<< HEAD
=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
>>>>>>> 69ad30d25db341addcb3897af610a7498254c940
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
=======
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

	private static final Logger log = LogManager.getLogger(ErrorCustomHandler.class);	
>>>>>>> 69ad30d25db341addcb3897af610a7498254c940
	
	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION_HANDLER ::: Capturei um erro");
<<<<<<< HEAD
		log.info("Payload ::: {}", message.getPayload());
		log.info("Headers ::: {}", message.getHeaders());
		log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
		log.info("Message exception ::: {}", exception.getMessage());
=======
>>>>>>> 69ad30d25db341addcb3897af610a7498254c940
		return null;
	}

}
