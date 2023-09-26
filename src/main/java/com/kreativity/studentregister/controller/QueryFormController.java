package com.kreativity.studentregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kreativity.studentregister.entity.QueryForm;
import com.kreativity.studentregister.service.QueryFormServiceImpl;
import java.util.Optional;


@RestController
@RequestMapping("/query-forms")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QueryFormController {
	 @Autowired
	    private QueryFormServiceImpl queryFormService;

	    @PostMapping
	    @CrossOrigin
	    public QueryForm createQueryForm(@RequestBody QueryForm queryForm) {
	        return queryFormService.saveQueryForm(queryForm);
	    }

	    @GetMapping
	    @CrossOrigin
	    public List<QueryForm> getAllQueryForms() {
	        return queryFormService.getAllQueryForms();
	    }

	    @GetMapping("/{qid}")
	    @CrossOrigin
	    public ResponseEntity<QueryForm> getQueryFormById(@PathVariable Integer qid) {
	        Optional<QueryForm> queryForm = queryFormService.getQueryFormById(qid);
	        return queryForm.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{qid}")
	    @CrossOrigin
	    public ResponseEntity<Void> deleteQueryForm(@PathVariable Integer qid) {
	        queryFormService.deleteQueryForm(qid);
	        return ResponseEntity.noContent().build();
	    }
}
