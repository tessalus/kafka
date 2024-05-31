package com.rafael.paymentservice.model;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Payment implements Serializable {

	private static final long serialVersionUID = 2457549196227511757L;
	
	private Long id;
	private Long idUser;
	private Long idProduct;
	private String cardNumber;	
	
	
}
