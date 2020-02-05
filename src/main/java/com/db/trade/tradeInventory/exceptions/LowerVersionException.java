package com.db.trade.tradeInventory.exceptions;

public class LowerVersionException extends RuntimeException{
	
	public LowerVersionException(String msg){
		super(msg);
	}

}
