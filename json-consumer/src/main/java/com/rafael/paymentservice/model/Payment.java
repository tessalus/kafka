package com.rafael.paymentservice.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Payment implements Serializable {

	private static final long serialVersionUID = -7006734390284145353L;
	
	private Long id;
	private Long idUser;
	private Long idProduct;
	private String cardNumber;	
	
	
}
