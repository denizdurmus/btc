package net.kadirderer.btc.query;

import net.kadirderer.btc.config.ApplicationConfig;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderbookService {
	
	@Autowired
	protected ApplicationConfig config;
	
	public abstract OrderbookResult query();
	
}
