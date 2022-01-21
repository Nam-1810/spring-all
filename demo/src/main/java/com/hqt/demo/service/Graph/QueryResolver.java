package com.hqt.demo.service.Graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

@Component
public class QueryResolver  {

	@Autowired
	private UsrInfoRepository usrInfoRepository;
	
	public DataFetcher<?> getAllDepartmentsDataFetcher() {
        return dataFetchingEnvironment -> usrInfoRepository.findAll();
    }
	
	 public DataFetcher<?> getUsrById() {
	        return dataFetchingEnvironment -> {
	            int id = dataFetchingEnvironment.getArgument("ID");
	            return usrInfoRepository.findById(id);
	        };
	    }

	
}
