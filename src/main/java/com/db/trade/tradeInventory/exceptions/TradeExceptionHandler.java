package com.db.trade.tradeInventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TradeExceptionHandler {
	
	@ExceptionHandler(LowerVersionException.class)
	public ResponseEntity<String> TradeException(){
		return new ResponseEntity("Version is lower", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TradeMaturedException.class)
	public ResponseEntity<String> TradeMaturedException(){
		return new ResponseEntity("Trade matured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
