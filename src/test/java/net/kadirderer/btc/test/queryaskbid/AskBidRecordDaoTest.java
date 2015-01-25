package net.kadirderer.btc.test.queryaskbid;

import static org.junit.Assert.assertNotEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import net.kadirderer.btc.db.dao.AskBidRecordDao;
import net.kadirderer.btc.db.model.AskBidRecord;
import net.kadirderer.btc.query.BtcPlatform;
import net.kadirderer.btc.query.OrderbookResult;
import net.kadirderer.btc.query.QueryService;
import net.kadirderer.btc.test.config.TestConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AskBidRecordDaoTest extends TestConfig {

	AskBidRecordDao abrd;
	QueryService qs;
	
	@Override
	public void getObjectFromContext(AnnotationConfigApplicationContext context) {
		
		abrd = context.getBean(AskBidRecordDao.class);
		qs = context.getBean(QueryService.class);
		
	}
	
	@Test
	public void insertRecordTest() {
		
		AskBidRecord abr = new AskBidRecord();
		
		OrderbookResult resultChina = qs.queryAskBid(BtcPlatform.BTCCHINA);
		OrderbookResult resultTr = qs.queryAskBid(BtcPlatform.BTCTURK);
		
		
		abr.setCnAskRmb(resultChina.getHighestAsk());
		abr.setCnBidRmb(resultChina.getHighestBid());
		abr.setCnAskTl((double)12);
		abr.setCnBidTl((double)23);
		abr.setTrAskRmb(resultTr.getHighestAsk());
		abr.setTrBidRmb(resultTr.getHighestBid());
		abr.setTrBidTl(resultTr.getHighestBid());
		abr.setTrAskTl(resultTr.getHighestAsk());
		
		abr.setRecordate(Timestamp.valueOf(LocalDateTime.now()));
		
		abrd.insert(abr);
		
		assertNotEquals(null, abr.getId());
		
	}

}
