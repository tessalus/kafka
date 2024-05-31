package com.rafael.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rafael.paymentservice.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonListener {

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "create-topic", containerFactory = "jsonContainerFactory")
	public void antiFraud(@Payload Payment payment) {
		log.info("Recebi o pagamento {}", payment.toString());
		Thread.sleep(2000L);
		
		log.info("Validando fraude ...");
		Thread.sleep(2000L);
		
		log.info("Compra aprovada ...");
		Thread.sleep(3000L);
	}
	
	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Payment payment) {
		Thread.sleep(3000L);
		log.info("Gerando PDF do produto de Id {}", payment.getId());
		Thread.sleep(2000L);
	}	
	
	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		Thread.sleep(3000L);
		log.info("Enviando email de confirmação ...");
	}	
	
}
