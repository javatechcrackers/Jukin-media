package com.covid.tracker.model;

import java.math.BigInteger;
import java.util.*;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;

@Entity
public class CovidData {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String country;

	private String code;

	private BigInteger confirmed;
	private BigInteger recovered;
	private BigInteger critical;
	private BigInteger deaths;
	private double latitude;
	private double longitude;
	private Date lastChange;
	private Date lastUpdate;

	@Convert(converter = StringListConverter.class)
	private List<String> comments;

	public static CovidData copy(CovidData src, CovidData dest) {
		if (null == dest) {
			dest = new CovidData();
			dest.setCode(src.getCode());
			dest.setCountry(src.getCountry());
			dest.setLatitude(src.getLatitude());
			dest.setLongitude(src.getLongitude());
		}
		dest.setConfirmed(src.getConfirmed());
		dest.setCritical(src.getCritical());
		dest.setDeaths(src.getDeaths());
		dest.setRecovered(src.getRecovered());
		dest.setLastChange(src.getLastChange());
		dest.setLastUpdate(src.getLastUpdate());
		return dest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigInteger getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(BigInteger confirmed) {
		this.confirmed = confirmed;
	}

	public BigInteger getRecovered() {
		return recovered;
	}

	public void setRecovered(BigInteger recovered) {
		this.recovered = recovered;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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

	public List<String> getComments() {
		if(CollectionUtils.isEmpty(comments)) {
			comments = new ArrayList<String>();
		}
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, comments, confirmed, country, critical, deaths, lastChange, lastUpdate, latitude,
				longitude, recovered);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidData other = (CovidData) obj;
		return Objects.equals(id, other.id) && Objects.equals(code, other.code)
				&& Objects.equals(comments, other.comments) && Objects.equals(confirmed, other.confirmed)
				&& Objects.equals(country, other.country) && Objects.equals(critical, other.critical)
				&& Objects.equals(deaths, other.deaths) && Objects.equals(lastChange, other.lastChange)
				&& Objects.equals(lastUpdate, other.lastUpdate) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude) && Objects.equals(recovered, other.recovered);
	}

	@Override
	public String toString() {
		return "CovidData [id=" + id + ", country=" + country + ", code=" + code + ", confirmed=" + confirmed
				+ ", recovered=" + recovered + ", critical=" + critical + ", deaths=" + deaths + ", latitude="
				+ latitude + ", longitude=" + longitude + ", lastChange=" + lastChange + ", lastUpdate=" + lastUpdate
				+ ", comments=" + comments + "]";
	}

	@Converter
	static class StringListConverter implements AttributeConverter<List<String>, String> {
		private static final String SPLIT_CHAR = ";";

		@Override
		public String convertToDatabaseColumn(List<String> stringList) {
			return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
		}

		@Override
		public List<String> convertToEntityAttribute(String string) {
			return string != null ? Arrays.asList(string.split(SPLIT_CHAR)) : Collections.emptyList();
		}
	}

}
