package com.hqt.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MailDao {
	@Autowired
	protected SqlSession session;
	
	public void addMail(String date, String Adress, String path) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cif", date);
		map.put("cusName", Adress);
		map.put("path", path);
		session.insert("mapper.mailMapper.insertMail", map);
		
	}

}
