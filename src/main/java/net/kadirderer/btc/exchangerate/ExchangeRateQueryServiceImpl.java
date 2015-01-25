package net.kadirderer.btc.exchangerate;

import net.kadirderer.btc.config.ApplicationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateQueryServiceImpl implements ExchangeRateQueryService {

	@Autowired
	private ApplicationConfig appConfig;
	
	@Override
	public ExchangeRateTable queryExchangeRateTable() {
		
		RestTemplate rt = new RestTemplate();
		return rt.getForObject(appConfig.getExchangeRateQueryUrl(), ExchangeRateTable.class);
		
	}

	@Override
	public ExchangeRateQueryResult queryRates(ExchangeRateQuery obj) {
		ExchangeRateTable erTable = queryExchangeRateTable();
		
		Double rate1 = erTable.getRates().get(obj.getFirstCurrency());
		Double rate2 = erTable.getRates().get(obj.getSecondCurrency());
		
		ExchangeRateQueryResult result = new ExchangeRateQueryResult();		
		result.setQuery(obj);
		result.setRateByFirst(rate2 / rate1);
		result.setRateBySecond(rate1 / rate2);
		
		return result;
	}

}
