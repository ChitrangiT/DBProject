package com.db.trade.tradeInventory.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.db.trade.tradeInventory.dao.Trade;
import com.db.trade.tradeInventory.exceptions.LowerVersionException;
import com.db.trade.tradeInventory.exceptions.TradeMaturedException;
import com.db.trade.tradeInventory.repository.TradeRepository;



@Service
public class TradeService {
	
	@Autowired
	TradeRepository tradeRepo;

	public String addTrade(Trade trade) {
		
		
		List<Trade> tradeList = getTradesByTradeid(trade.getTradeId());
		if(null!=tradeList && !tradeList.isEmpty()) {
		Trade maxVersionTrade = tradeList.stream().collect(Collectors.maxBy(Comparator.comparing(Trade::getVersion))).orElse(null);
		if(maxVersionTrade!=null) {
			if(maxVersionTrade.getVersion()>trade.getVersion()) {
				throw new LowerVersionException(" Trade version is lower.");
			}
			
		}
		}
		Date todaysDate = new Date();
		if(trade.getMaturityDate().before(todaysDate)) {
			throw new TradeMaturedException(" Trade is already matured");
		}
		
		Trade createdTrade= tradeRepo.save(trade);
		return createdTrade.getTradeId();
		
		
	}

	private List<Trade> getTradesByTradeid(String tradeId) {
		// TODO Auto-generated method stub
		List<Trade> tradeListById = tradeRepo.findBytradeId(tradeId);
		return tradeListById;
	}
	
	public List<Trade> getTrades(){
		List<Trade> tradeList = (List<Trade>) tradeRepo.findAll();
		return tradeList;
	}

}
