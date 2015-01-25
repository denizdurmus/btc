package net.kadirderer.btc.db.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kadirderer.btc.db.model.AskBidRecord;
import net.kadirderer.btc.db.repository.AskBidRecordRepository;

@Service
public class AskBidRecordDaoImpl implements AskBidRecordDao {
	
	@Autowired
	private AskBidRecordRepository askBidRecordRepository;

	@Override
	@Transactional(readOnly = true)
	public List<AskBidRecord> queryAllRecords() {
		
		return askBidRecordRepository.findAll();
	}

	@Override
	public List<AskBidRecord> queryLastHours(int hour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AskBidRecord> queryTimeInterval(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AskBidRecord insert(AskBidRecord askBidRecord) {
		
		return askBidRecordRepository.save(askBidRecord);
	}

}
