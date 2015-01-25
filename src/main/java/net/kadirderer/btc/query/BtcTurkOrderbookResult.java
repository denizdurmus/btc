package net.kadirderer.btc.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BtcTurkOrderbookResult implements OrderbookResult {
	
	private String asks[][];
	private String bids[][];
	
	public String[][] getAsks() {
		return asks;
	}
	public void setAsks(String[][] ask) {
		this.asks = ask;
	}
	public String[][] getBids() {
		return bids;
	}
	public void setBids(String[][] bid) {
		this.bids = bid;
	}
	
	
	@Override
	public Double getHighestAsk() {
		return Double.valueOf(asks[0][0]);
	}
	@Override
	public Double getHighestBid() {
		// TODO Auto-generated method stub
		return Double.valueOf(bids[0][0]);
	}
	

}
