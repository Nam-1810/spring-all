package com.hqt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqt.demo.dao.UsrInfoDao;
import com.hqt.demo.entities.UsrInfo;



@Service
public class UsrInfoService {
	
	@Autowired
	UsrInfoDao usr_infoDao;
	
	public List<UsrInfo> findAll()
	{
		return usr_infoDao.findAllUser();
	
	}
	
	public UsrInfo selectById(int id)
	{
		return usr_infoDao.selectById(id);
	}
	
	public void insert(UsrInfo parameterMap)
	{
		usr_infoDao.insert(parameterMap);
	}
	
	public void update(UsrInfo parameterMap)
	{
		usr_infoDao.update(parameterMap);
	}
	
	public void delete(UsrInfo parameterMap)
	{
		usr_infoDao.update(parameterMap);
	}
}
