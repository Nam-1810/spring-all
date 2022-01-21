package com.hqt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqt.demo.dao.SysMenuDao;
import com.hqt.demo.entities.SysMenu;

@Service
public class SysMenuService {
	
	@Autowired
	SysMenuDao sysMenuDao;

	public List<SysMenu> selectMenuParent()
	{
		return sysMenuDao.selectMenuParent();
	}
	
	public List<SysMenu> selectMenuChild(Integer id)
	{
		return sysMenuDao.selectMenuChild(id);
	}
}
