package com.db.trade.tradeInventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.trade.tradeInventory.dao.Trade;
import com.db.trade.tradeInventory.services.TradeService;

@Controller
@RequestMapping("/trades")
public class TradeController {
	
	@Autowired
	TradeService tradeService;
	
	@PostMapping("/addTrade")
	public ResponseEntity<String> addTrade(@RequestBody Trade trade){
		String tradeid = tradeService.addTrade(trade);
		return new ResponseEntity("Trade added successfully with trade id "+tradeid , HttpStatus.CREATED);
	}
	
	

	@GetMapping("/all")
	public ResponseEntity<List<Trade>> getTrade(){
		List<Trade> tradeList = tradeService.getTrades();
		return new ResponseEntity(tradeList,HttpStatus.OK);
	}

}
