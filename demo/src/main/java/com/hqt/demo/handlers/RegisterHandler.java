package com.hqt.demo.handlers;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.hqt.demo.entities.Bill;
import com.hqt.demo.entities.FlowModel;
import com.hqt.demo.entities.UsrInfo;

@Component
public class RegisterHandler {

	public FlowModel init() {
		return new FlowModel();
	}
	
	public void addPersonalInfo(FlowModel flowModel, UsrInfo usrInfo) {
		flowModel.setUsrInfo(usrInfo);
	}
	
	public void addBill(FlowModel flowModel, Bill bill) {
		flowModel.setBill(bill);
	}
	
	public String validatePersonalInfo(UsrInfo usrInfo, MessageContext error) {
		String transitionValue = "success";

		if (usrInfo.getUSERNAME().equalsIgnoreCase("Nam")) {
			error.addMessage(new MessageBuilder(). //
					error() //
					.source("USERNAME") //
					.defaultText("You are not allowed to use Nam as the username!") //
					.build());

			transitionValue = "failure";
		}

		return transitionValue;
	}
}
