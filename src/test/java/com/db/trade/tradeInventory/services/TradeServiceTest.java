package com.db.trade.tradeInventory.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.db.trade.tradeInventory.dao.Trade;
import com.db.trade.tradeInventory.repository.TradeRepository;



@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTest {
	
	@Mock
	TradeService tradeService;
	
	@Mock
	TradeRepository tradeRepository;
	
	Trade trade;
	
	@Before
	public void Setup() {
		Trade trade = new Trade();
		trade.setBookId("B1");
		trade.setTradeId("T1");
	}
	
	@Test
	public void addTradeTest() {
		Mockito.when(tradeRepository.save(trade)).thenReturn(trade);
		tradeService.addTrade(trade);
		
		
	}
	

}
