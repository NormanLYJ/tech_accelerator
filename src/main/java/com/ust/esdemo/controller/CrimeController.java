package com.ust.esdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.esdemo.model.Crime;
import com.ust.esdemo.service.CrimeRecordService;

@RestController
@RequestMapping("/crime")
public class CrimeController {

	private CrimeRecordService service;

	@Autowired
	public CrimeController(CrimeRecordService service) {

		this.service = service;
	}

	@PostMapping("/records")
	public boolean createCrimeRecords(@RequestBody Map<String, Object> payload) {
		return service.indexCrimeRecords(payload);
	}

	@PostMapping("/records/search")
	public List<Crime> searchCrimeRecords(@RequestBody Map<String, Object> payload) {
		List<Crime> crimeIds = service.getCrimeIdOfMatchRecords((String) payload.get("fieldName"),
				(String) payload.get("searchString"));
		return crimeIds;
	}

}
