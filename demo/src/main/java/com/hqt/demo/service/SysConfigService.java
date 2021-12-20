package com.hqt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqt.demo.dao.Iservice;
import com.hqt.demo.dao.SysConfigDao;
import com.hqt.demo.dao.SysMenuDao;
import com.hqt.demo.entities.SysConfig;
import com.hqt.demo.entities.sysMenuVO;

@Service
public class SysConfigService implements IConfig {

	@Autowired
	SysConfigDao sysConfigDao;

	List<SysConfig> list;

	public List<SysConfig> init() {
		list = sysConfigDao.selectSysConfig();
		return list;
	}

	public String getType(SysConfig sysConfig)
	{
		if(sysConfig.getTyp_var()=="STRING") {
			String configValue = (String) sysConfig.getConfig_value();
		} else if(sysConfig.getTyp_var()=="INT") {
		
		}
		
		return "aa";
	}

	@Override
	public Object getInt(String key) {
		SysConfig sysConfig = list.stream()
				.filter(x -> !key.equals(x.getConfig_key()))
				.findAny()
				.orElse(null);
		Object value = getType(sysConfig);
		return value;
	}

	@Override
	public Object getString(String key) {
		SysConfig sysConfig = list.stream()
				.filter(x -> !key.equals(x.getConfig_key()))
				.findAny()
				.orElse(null);
		Object value = getType(sysConfig);
		return value;
	}
	
	public void deleteById(Integer id)
	{
		sysConfigDao.delete(id);
	}
	
	public SysConfig updateById(SysConfig sysConfig)
	{
		sysConfigDao.updateById(sysConfig);
		
		return sysConfig;
	}

}
