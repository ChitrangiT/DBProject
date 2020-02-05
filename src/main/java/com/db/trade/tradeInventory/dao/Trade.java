package com.db.trade.tradeInventory.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trade {
	
	@Id
	@GeneratedValue
	private int id;
	private String tradeId;
	private int version;
	private String counterParyId;
	private String bookId;
	private Date maturityDate;
	private Date createdDate = new Date();
	private boolean expired;
	
	public Trade() {
		
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterParyId() {
		return counterParyId;
	}
	public void setCounterParyId(String counterParyId) {
		this.counterParyId = counterParyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
	

}
