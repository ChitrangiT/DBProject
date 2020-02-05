package com.db.trade.tradeInventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.trade.tradeInventory.dao.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade,Integer>{
	
	public List<Trade> findBytradeId(String tradeId);

}
