package com.covid.tracker.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidTotal {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private BigInteger confirmed;
	private BigInteger critical;
	private BigInteger deaths;
	private Date lastChange;
	private Date lastUpdate;
	private BigInteger recovered;

	public CovidTotal() {
		super();
	}

	public CovidTotal(BigInteger confirmed, BigInteger critical, BigInteger deaths, Date lastChange,
			Date lastUpdate, BigInteger recovered) {
		super();
		this.confirmed = confirmed;
		this.critical = critical;
		this.deaths = deaths;
		this.lastChange = lastChange;
		this.lastUpdate = lastUpdate;
		this.recovered = recovered;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(BigInteger confirmed) {
		this.confirmed = confirmed;
	}

	public BigInteger getCritical() {
		return critical;
	}

	public void setCritical(BigInteger critical) {
		this.critical = critical;
	}

	public BigInteger getDeaths() {
		return deaths;
	}

	public void setDeaths(BigInteger deaths) {
		this.deaths = deaths;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public BigInteger getRecovered() {
		return recovered;
	}

	public void setRecovered(BigInteger recovered) {
		this.recovered = recovered;
	}

	@Override
	public int hashCode() {
		return Objects.hash(confirmed, critical, deaths, lastChange, lastUpdate, recovered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidTotal other = (CovidTotal) obj;
		return Objects.equals(confirmed, other.confirmed) && Objects.equals(critical, other.critical)
				&& Objects.equals(deaths, other.deaths) && Objects.equals(recovered, other.recovered);
	}

	@Override
	public String toString() {
		return "CovidTotal [confirmed=" + confirmed + ", critical=" + critical + ", deaths=" + deaths + ", lastChange="
				+ lastChange + ", lastUpdate=" + lastUpdate + ", recovered=" + recovered + "]";
	}

}
