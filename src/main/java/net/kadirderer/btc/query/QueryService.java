package net.kadirderer.btc.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
	
	@Autowired
	private BtcTurkOrderbookServiceImpl btcTurkOrderbookService;
	
	@Autowired
	private BtcChinaOrderbookServiceImpl btcChinaOrderbookService;
	
	
	public OrderbookResult queryAskBid(BtcPlatform platform) {
		
		OrderbookResult result = null;
		
		switch (platform) {
		case BTCCHINA:
			result = btcChinaOrderbookService.query();
			break;
		case BTCTURK:
			result = btcTurkOrderbookService.query();
			break;
		default:
			break;
		}
		
		return result;
	}

}
