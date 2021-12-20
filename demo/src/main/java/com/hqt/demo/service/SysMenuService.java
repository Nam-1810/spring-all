package com.hqt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqt.demo.dao.SysMenuDao;
import com.hqt.demo.entities.sysMenuVO;

@Service
public class SysMenuService {
	
	@Autowired
	SysMenuDao sysMenuDao;

	public List<sysMenuVO> selectMenuParent()
	{
		return sysMenuDao.selectMenuParent();
	}
	
	public List<sysMenuVO> selectMenuChild(Integer id)
	{
		return sysMenuDao.selectMenuChild(id);
	}
}
