package com.covid.tracker.repsitory;

import java.util.List;

import com.covid.tracker.model.CovidData;
import org.springframework.data.repository.CrudRepository;


public interface CovidDataRepository extends CrudRepository<CovidData, Long> {

	//public List<CovidData> findAllByCountry(String country);
	
	public CovidData findByCountry(String country);
	public CovidData findByCode(String code);
	
	//public List<CovidData> findAllByCode(String code);
	
}
