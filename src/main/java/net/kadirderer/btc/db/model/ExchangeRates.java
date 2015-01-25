package net.kadirderer.btc.db.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_BTCPLATFORM")
public class ExchangeRates {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	
	@Column(name = "RECORDID", nullable = false)
	private BigInteger recordId;
	
	@Column(name = "RATES_MAP", nullable = false)
	private String ratesMap;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getRecordId() {
		return recordId;
	}

	public void setRecordId(BigInteger recordId) {
		this.recordId = recordId;
	}

	public String getRatesMap() {
		return ratesMap;
	}

	public void setRatesMap(String ratesMap) {
		this.ratesMap = ratesMap;
	}

}
