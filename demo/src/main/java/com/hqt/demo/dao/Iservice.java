package com.hqt.demo.dao;

import java.util.List;


public interface Iservice<T extends Object> {
	

	public <T> List<T> findAll(String queryId);

	void insert(String queryId, Object parameterMap);

	void update(String queryId, Object parameterMap);

	void delete(String queryId, Object parameterMap);

	T selectById(String queryId, int id);

}
