package net.kadirderer.btc.db.repository;

import java.math.BigInteger;

import net.kadirderer.btc.db.model.AskBidRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AskBidRecordRepository extends JpaRepository<AskBidRecord, BigInteger> {

}
