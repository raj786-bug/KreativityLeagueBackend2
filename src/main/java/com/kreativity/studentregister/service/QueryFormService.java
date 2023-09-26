package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import com.kreativity.studentregister.entity.QueryForm;


public interface QueryFormService {
	QueryForm saveQueryForm(QueryForm queryForm);
    List<QueryForm> getAllQueryForms();
    Optional<QueryForm> getQueryFormById(Integer qid);
    void deleteQueryForm(Integer qid);
}
