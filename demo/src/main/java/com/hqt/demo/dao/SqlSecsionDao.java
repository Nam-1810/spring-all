package com.hqt.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlSecsionDao<T> implements Iservice<T> {

	@Autowired
	protected SqlSession session;

	@Override
	public <T> List<T> findAll(String queryId) {
		return session.selectList(queryId);
	}

	@Override
	public void insert(String queryId, Object parameterMap) {
		// TODO Auto-generated method stub
		session.insert(queryId, parameterMap);
	}

	@Override
	public void update(String queryId, Object parameterMap) {
		// TODO Auto-generated method stub
		session.update(queryId, parameterMap);

	}

	@Override
	public void delete(String queryId, Object parameterMap) {
		// TODO Auto-generated method stub
		session.update(queryId, parameterMap);
	}

	@Override
	public T selectById(String queryId, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
