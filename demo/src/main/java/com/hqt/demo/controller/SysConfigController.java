package com.hqt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqt.demo.entities.SysConfig;
import com.hqt.demo.service.SysConfigService;

@Controller
public class SysConfigController {
	
	@Autowired
	SysConfigService sysConfigService;
	
	@RequestMapping(value="/configData",method = RequestMethod.GET)
	@ResponseBody
	public List<SysConfig> sysConfig() {
		List<SysConfig> list = sysConfigService.init();
		return list;
	}
	
	@RequestMapping(value="/sysConfig/{id}",method = RequestMethod.GET)
	public SysConfig deleteById(@PathVariable("id") Integer id) {
		sysConfigService.deleteById(id);
		return null;
	}
	
	@RequestMapping(value="/sysConfig/changle",method = RequestMethod.POST)
	@ResponseBody
	public SysConfig updateConfig(@RequestBody SysConfig sysConfig) {
		if(sysConfig.getId() == 0)
		{
			System.out.println("create sysconfig");
		} else {
			sysConfigService.updateById(sysConfig);
		}
		return sysConfig;
	}
	

}
