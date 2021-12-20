package com.hqt.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hqt.demo.entities.SysConfig;
@Repository
public class SysConfigDao extends SqlSecsionDao<SysConfig> {
	
	public List<SysConfig> selectSysConfig() {
		List<SysConfig> list = session.selectList("mapper.sysConfigMapper.selectSysConfig");
		return list;
	}
	
	public SysConfig selectByConfigKey(String SysConfigKey) {
		SysConfig sysConfig = session.selectOne("mapper.sysConfigMapper.selectByConfigKey", SysConfigKey);
		return sysConfig;
	}
	
	public void delete(Integer id) {
		super.delete("mapper.sysConfigMapper.deleteById", id);
	}
	
	public void updateById(SysConfig sysConfig) {
		super.update("mapper.sysConfigMapper.updateById", sysConfig);
	}
	

}
