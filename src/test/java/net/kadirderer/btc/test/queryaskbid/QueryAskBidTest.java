package net.kadirderer.btc.test.queryaskbid;

import static org.junit.Assert.assertNotNull;
import net.kadirderer.btc.query.BtcPlatform;
import net.kadirderer.btc.query.OrderbookResult;
import net.kadirderer.btc.query.QueryService;
import net.kadirderer.btc.test.config.TestConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryAskBidTest extends TestConfig {
	
	private QueryService qs;	
	
	@Test
	public void testBtcTurkey() {
		OrderbookResult result = qs.queryAskBid(BtcPlatform.BTCTURK);
		
		assertNotNull(result.getHighestAsk());
		
	}
	
	@Test
	public void testBtcChina() {
		OrderbookResult result = qs.queryAskBid(BtcPlatform.BTCCHINA);
		
		assertNotNull(result.getHighestAsk());
		
	}

	@Override
	public void getObjectFromContext(AnnotationConfigApplicationContext context) {
		qs = context.getBean(QueryService.class);		
	}	
	

}
