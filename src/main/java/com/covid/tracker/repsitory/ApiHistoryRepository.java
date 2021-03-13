package com.covid.tracker.repsitory;

import java.util.List;

import org.springframework.data.domain.Sort;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.tracker.model.ApiHistory;

@Repository
public interface ApiHistoryRepository extends CrudRepository<ApiHistory, Long> {

	public List<ApiHistory> findAllByApiName(String apiName);
	public List<ApiHistory> findAllByApiNameAndType(String apiName,String type);

}
