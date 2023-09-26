package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.QueryForm;
import com.kreativity.studentregister.repo.QueryFormRepo;

@Service
public class QueryFormServiceImpl implements QueryFormService{

	 @Autowired
	    private QueryFormRepo queryFormRepository;

	    @Override
	    public QueryForm saveQueryForm(QueryForm queryForm) {
	        return queryFormRepository.save(queryForm);
	    }

	    @Override
	    public List<QueryForm> getAllQueryForms() {
	        return queryFormRepository.findAll();
	    }

	    @Override
	    public Optional<QueryForm> getQueryFormById(Integer qid) {
	        return queryFormRepository.findById(qid);
	    }

	    @Override
	    public void deleteQueryForm(Integer qid) {
	        queryFormRepository.deleteById(qid);
	    }

}
