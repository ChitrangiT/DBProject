package com.db.trade.tradeInventory.controllers;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.db.trade.tradeInventory.dao.Trade;
import com.db.trade.tradeInventory.services.TradeService;

@RunWith(MockitoJUnitRunner.class)
public class TradeControllerTest {
	
	@Mock
	TradeController tradeController;
	
	@Mock
	TradeService tradeService;
	
	Trade trade;

	@Before
	public void setUp() {
		trade = new Trade();
		trade.setBookId("B1");
		trade.setTradeId("T1");
		trade.setCounterParyId("CP-2");
		trade.setMaturityDate(new Date("2020-03-23"));
		trade.setVersion(2);
	}
	
	@Test
	public void addTradeTest() {
		Mockito.when(tradeService.addTrade(trade)).thenReturn("T1");
		tradeController.addTrade(trade);
		Mockito.verify(tradeService,Mockito.times(1)).addTrade(trade);
		
	}
	
	@Test
	public void maturityExceptionTest() {
		
	}
	
	@Test
	public void versionExceptionTest() {
		
	}

}
