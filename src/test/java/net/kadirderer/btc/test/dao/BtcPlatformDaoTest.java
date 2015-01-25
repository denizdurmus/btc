package net.kadirderer.btc.test.dao;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kadirderer.btc.db.dao.BtcPlatformDao;
import net.kadirderer.btc.db.model.BtcPlatform;
import net.kadirderer.btc.test.config.TestConfig;
import static org.junit.Assert.*;

public class BtcPlatformDaoTest extends TestConfig {
	
	private BtcPlatformDao btcPlatformDao;

	@Override
	public void getObjectFromContext(AnnotationConfigApplicationContext context) {
		btcPlatformDao = context.getBean(BtcPlatformDao.class);

	}
	
	
	@Test
	public void insertTest() {
		BtcPlatform platform = new BtcPlatform();
		
		platform.setCode("TestCode");
		platform.setName("TestPlatform");
		platform.setHomeUrl("homeUrl");
		platform.setCurrency("SSSS");
		
		btcPlatformDao.insert(platform);
		
		assertNotNull(platform.getId());
		
	}

}
