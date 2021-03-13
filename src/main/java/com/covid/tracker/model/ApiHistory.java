package com.covid.tracker.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class ApiHistory {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String apiName;

	private String type;

	private Date date;

	public ApiHistory() {
		super();
	}

	public ApiHistory(String apiName, Date date, String type) {
		super();
		this.apiName = apiName;
		this.date = date;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, apiName, date, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiHistory other = (ApiHistory) obj;
		return Objects.equals(id, other.id) && Objects.equals(apiName, other.apiName)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ApiHistory [id=" + id + ", apiName=" + apiName + ", type=" + type + ", date=" + date + "]";
	}
}
