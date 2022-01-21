package com.hqt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hqt.demo.service.Graph.GraphQlService;

import graphql.ExecutionResult;

@Controller
public class GraphController {

	@Autowired
	private GraphQlService graphQLService;

    @PostMapping("/graphql/usr")
    public ResponseEntity<Object> listDepartments(@RequestBody String query){
    	System.out.println("query" + query);
        ExecutionResult execute = graphQLService.executeGraphQL(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
