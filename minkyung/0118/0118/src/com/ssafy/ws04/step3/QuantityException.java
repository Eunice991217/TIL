package com.ssafy.ws04.step3;

@SuppressWarnings("serial")
public class QuantityException extends Exception{
	
	public QuantityException() {
		super("수량이 부족합니다.");
	}
}

