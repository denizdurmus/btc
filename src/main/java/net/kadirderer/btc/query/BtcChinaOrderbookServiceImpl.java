package net.kadirderer.btc.query;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BtcChinaOrderbookServiceImpl extends OrderbookService {

	@Override
	public OrderbookResult query() {
		RestTemplate rt = new RestTemplate();
		return rt.getForObject(config.getBtcChinaOrderBookUrl(), BtcChinaOrderbookResult.class);
	}

}
