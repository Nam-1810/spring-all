package com.hqt.demo.controller;

import org.springframework.stereotype.Component;

import com.hqt.demo.entities.FlowModel;
import com.hqt.demo.entities.UsrInfo;


@Component
public class webFlowController {
	 
	FlowModel flowModel = new FlowModel();
	
	public void addPersonalInfo(UsrInfo UsrInfo) {
		flowModel.setUsrInfo(UsrInfo);
	}

}
