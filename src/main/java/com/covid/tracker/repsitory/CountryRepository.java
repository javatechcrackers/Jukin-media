package com.covid.tracker.repsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.tracker.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	
	public Country findByName(String name);
}
