package com.ust.esdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import com.ust.esdemo.dao.CrimeDAO;
import com.ust.esdemo.model.Crime;

@Service
public class CrimeRecordService {

	private static final String indexName = "crime_data";

	@Autowired
	private CrimeDAO crimedao;

	private ElasticsearchOperations esOperations;

	@Autowired
	public CrimeRecordService(ElasticsearchOperations client) {
		this.esOperations = client;
	}

	public boolean createProductIndexBulk(final List<Crime> crimeList) {
		List<IndexQuery> queries = crimeList.stream()
				.map(crime -> new IndexQueryBuilder().withId(crime.getCrimeId().toString()).withObject(crime).build())
				.collect(Collectors.toList());
		;
		return esOperations.bulkIndex(queries, IndexCoordinates.of(indexName)).size() > 0 ? true : false;
	}

	public boolean indexCrimeRecords(final Map<String, Object> payload) {
		boolean indexNRecordsCreated = false;
		List<Crime> crimeRecords = crimedao.getCrimeRecords(payload);
		indexNRecordsCreated = createProductIndexBulk(crimeRecords);
		return indexNRecordsCreated;
	}

	public List<Crime> getCrimesByDescription(String fieldName, String crimeDescription) {
		// QueryBuilder queryBuilder = QueryBuilders.matchQuery(fieldName,
		// crimeDescription);
		return null;
	}

	/**
	 * Implements wildcard search on top of a particular index in ES.
	 * 
	 * @param fieldName
	 * @param searchWord
	 * @return
	 */
	public List<Crime> getCrimeIdOfMatchRecords(final String fieldName, final String searchWord) {
		QueryBuilder builder = QueryBuilders.wildcardQuery(fieldName, searchWord + "*");
		Query searchQuery = new NativeSearchQueryBuilder().withFilter(builder).withPageable(PageRequest.of(0, 5))
				.build();
		SearchHits<Crime> searchResult = esOperations.search(searchQuery, Crime.class, IndexCoordinates.of(indexName));
		List<Crime> crimeIdList = new ArrayList<>();
		searchResult.getSearchHits().forEach(searchHit -> {
			crimeIdList.add(searchHit.getContent());
		});
		return crimeIdList;
	}

	public List<Crime> deleteAllTheRecords() {

		// esOperations.delete(null, IndexCoordinates.of(indexName));
		return null;
	}

}
