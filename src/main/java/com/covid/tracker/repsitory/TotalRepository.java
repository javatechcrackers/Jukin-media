package com.covid.tracker.repsitory;

import com.covid.tracker.model.CovidTotal;
import org.springframework.data.repository.CrudRepository;

public interface TotalRepository extends CrudRepository<CovidTotal, Long> {

}
