package net.kadirderer.btc.exchangerate;

public interface ExchangeRateQueryService {
	
	public ExchangeRateTable queryExchangeRateTable();
	
	public ExchangeRateQueryResult queryRates(ExchangeRateQuery obj);
	

}
