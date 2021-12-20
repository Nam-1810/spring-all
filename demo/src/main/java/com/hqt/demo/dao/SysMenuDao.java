package com.hqt.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hqt.demo.entities.sysMenuVO;
@Repository
public class SysMenuDao extends SqlSecsionDao<sysMenuVO> {
	
	public List<sysMenuVO> selectMenuParent() {
		List<sysMenuVO> list = session.selectList("mapper.sysMenuMapper.selectMenuParent");
		return list;
	}
	
	public List<sysMenuVO> selectMenuChild(Integer id) {
		List<sysMenuVO> list = session.selectList("mapper.sysMenuMapper.selectMenuChild", id);
		return list;
	}

}
