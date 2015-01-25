package net.kadirderer.btc.test.exchangerate;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kadirderer.btc.exchangerate.ExchangeRateQuery;
import net.kadirderer.btc.exchangerate.ExchangeRateQueryResult;
import net.kadirderer.btc.exchangerate.ExchangeRateQueryService;
import net.kadirderer.btc.exchangerate.ExchangeRateTable;
import net.kadirderer.btc.test.config.TestConfig;
import static org.junit.Assert.*;

public class ExchangeRateTest extends TestConfig {
	
	private ExchangeRateQueryService erqs;
	
	@Override
	public void getObjectFromContext(AnnotationConfigApplicationContext context) {
		erqs = context.getBean(ExchangeRateQueryService.class);
	}
	
	
	@Test
	public void queryTest() {
		ExchangeRateTable table = erqs.queryExchangeRateTable();
		
		assertNotNull(table.getRates().get("TRY"));
	}
	
	@Test
	public void queryExchangeRateTest() {
		
		ExchangeRateQuery query = new ExchangeRateQuery();
		query.setFirstCurrency("TRY");
		query.setSecondCurrency("CNY");
		
		ExchangeRateQueryResult result = erqs.queryRates(query);
		
		assertEquals(2.65, result.getRateByFirst(), 0.05);
		
	}

}
