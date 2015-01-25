package net.kadirderer.btc.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kadirderer.btc.db.model.BtcPlatform;
import net.kadirderer.btc.db.repository.BtcPlatformRepository;

@Service
public class BtcPlatformDaoImpl implements BtcPlatformDao {
	
	@Autowired
	private BtcPlatformRepository btcPlatformRepository;

	@Override
	public BtcPlatform insert(BtcPlatform platform) {
		return btcPlatformRepository.save(platform);
	}

}
