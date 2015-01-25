package net.kadirderer.btc.web.controller;

import java.sql.Timestamp;
import java.util.Calendar;

import net.kadirderer.btc.db.dao.AskBidRecordDao;
import net.kadirderer.btc.db.model.AskBidRecord;
import net.kadirderer.btc.query.BtcPlatform;
import net.kadirderer.btc.query.OrderbookResult;
import net.kadirderer.btc.query.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private QueryService qs;
	
	@Autowired
	private AskBidRecordDao abrd;
	
	@RequestMapping("/index")
	public String index() {
		
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
		
		abr.setRecordate(Timestamp.valueOf(Calendar.getInstance().getTime() + ""));
		
		abrd.insert(abr);
		
		return "index";
	}

}
