package net.kadirderer.btc.db.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ASKBIDRECORD")
public class AskBidRecord {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	
	@Column(name = "CN_ASK_RMB", nullable = false)
	private Double cnAskRmb;
	
	@Column(name = "TR_ASK_RMB", nullable = false)
	private Double trAskRmb;
	
	@Column(name = "CN_BID_RMB", nullable = false)
	private Double cnBidRmb;
	
	@Column(name = "TR_BID_RMB", nullable = false)
	private Double trBidRmb;
	
	@Column(name = "CN_ASK_TL", nullable = false)
	private Double cnAskTl;
	
	@Column(name = "TR_ASK_TL", nullable = false)
	private Double trAskTl;
	
	@Column(name = "CN_BID_TL", nullable = false)
	private Double cnBidTl;
	
	@Column(name = "TR_BID_TL", nullable = false)
	private Double trBidTl;
	
	@Column(name = "RECORDDATE", nullable = false)
	private Timestamp recordate;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public Double getCnAskRmb() {
		return cnAskRmb;
	}
	public void setCnAskRmb(Double cnAskRmb) {
		this.cnAskRmb = cnAskRmb;
	}
	public Double getTrAskRmb() {
		return trAskRmb;
	}
	public void setTrAskRmb(Double trAskRmb) {
		this.trAskRmb = trAskRmb;
	}
	public Double getCnBidRmb() {
		return cnBidRmb;
	}
	public void setCnBidRmb(Double cnBidRmb) {
		this.cnBidRmb = cnBidRmb;
	}
	public Double getTrBidRmb() {
		return trBidRmb;
	}
	public void setTrBidRmb(Double trBidRmb) {
		this.trBidRmb = trBidRmb;
	}
	public Double getCnAskTl() {
		return cnAskTl;
	}
	public void setCnAskTl(Double cnAskTl) {
		this.cnAskTl = cnAskTl;
	}
	public Double getTrAskTl() {
		return trAskTl;
	}
	public void setTrAskTl(Double trAskTl) {
		this.trAskTl = trAskTl;
	}
	public Double getCnBidTl() {
		return cnBidTl;
	}
	public void setCnBidTl(Double cnBidTl) {
		this.cnBidTl = cnBidTl;
	}
	public Double getTrBidTl() {
		return trBidTl;
	}
	public void setTrBidTl(Double trBidTl) {
		this.trBidTl = trBidTl;
	}
	public Timestamp getRecordate() {
		return recordate;
	}
	public void setRecordate(Timestamp recordate) {
		this.recordate = recordate;
	}
}
