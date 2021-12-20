package com.hqt.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hqt.demo.entities.UsrInfo;

@Repository
public class UsrInfoDao extends SqlSecsionDao<UsrInfo> {

	
	public List<UsrInfo> findAllUser() {
		return super.findAll("mapper.usrInfoMapper.selectAll");
	}
	
	public UsrInfo selectById(int id) {
		return super.selectById("mapper.usrInfoMapper.selectById", id);
	}
	
	public void insert(UsrInfo parameterMap) {
		super.insert("mapper.usrInfoMapper.insert", parameterMap);
	}
	
	public void update(UsrInfo parameterMap) {
		super.update("mapper.usrInfoMapper.update", parameterMap);
	}
	
	public void delete(UsrInfo parameterMap) {
		super.delete("mapper.usrInfoMapper.delete", parameterMap);
	}
	
	public UsrInfo selectByUserName(String username) {
		UsrInfo usrInfo = session.selectOne("mapper.usrInfoMapper.selectByUserName", username);
		return usrInfo;
	}


}
