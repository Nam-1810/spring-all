package com.hqt.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hqt.demo.entities.SysMenu;
@Repository
public class SysMenuDao extends SqlSecsionDao<SysMenu> {
	
	public List<SysMenu> selectMenuParent() {
		List<SysMenu> list = session.selectList("mapper.sysMenuMapper.selectMenuParent");
		return list;
	}
	
	public List<SysMenu> selectMenuChild(Integer id) {
		List<SysMenu> list = session.selectList("mapper.sysMenuMapper.selectMenuChild", id);
		return list;
	}

}
