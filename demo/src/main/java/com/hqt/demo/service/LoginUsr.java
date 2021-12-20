
package com.hqt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hqt.demo.dao.UsrInfoDao;
import com.hqt.demo.dao.UsrTokenDao;
import com.hqt.demo.entities.UsrInfo;

@Service
public class LoginUsr implements UserDetailsService {

	@Autowired
	UsrInfoDao usrInfoDao;
	
	@Autowired
	UsrTokenDao usrTokenDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		UsrInfo user = usrInfoDao.selectByUserName(username);	
	
		UserBuilder builder = null;
		 if (user != null) {
			 //create session
		      builder = org.springframework.security.core.userdetails.User.withUsername(username);
		      builder.password(user.getPASSWORD());
		      builder.roles("USER");
		     //create token
		     
		    } else {
		      throw new UsernameNotFoundException("User not found.");
		    }
		return builder.build();
		
		  }
	}

