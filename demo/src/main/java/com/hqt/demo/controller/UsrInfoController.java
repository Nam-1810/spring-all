package com.hqt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hqt.demo.entities.UsrInfo;
import com.hqt.demo.service.UsrInfoService;



@Controller
public class UsrInfoController {

	@Autowired
	UsrInfoService usr_infoService;
	
	@RequestMapping("/usrInfo")
	public List<UsrInfo> helloWorld(Model model) {
		List<UsrInfo> list = usr_infoService.findAll();
		return list;
	}
	

	@PostMapping("/register") 
	public String register(Model model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("lastName") String lastName,
			@RequestParam("firstName") String firstName, @RequestParam("email") String email) {
		String passwordBcrypt = BCrypt.hashpw(password, BCrypt.gensalt(12));
		UsrInfo user = new UsrInfo();
		user.setUSERNAME(username);
		user.setPASSWORD(passwordBcrypt);
		user.setLAST_NAME(lastName);
		user.setFIRST_NAME(firstName);
		user.setFULL_NAME(firstName + " "+ lastName);
		user.setEMAIL(email);
		try {
			usr_infoService.insert(user);
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

}
