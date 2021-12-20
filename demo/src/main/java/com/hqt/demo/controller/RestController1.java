package com.hqt.demo.controller;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hqt.demo.entities.AuthenticatioanResponse;
import com.hqt.demo.entities.UsrInfo;
import com.hqt.demo.service.LoginUsr;
import com.hqt.demo.service.UsrInfoService;
import com.hqt.demo.util.JwtUtil;

@RestController
@RequestMapping("/rest")

public class RestController1 {
	
	@Autowired
	StreamsBuilderFactoryBean factoryBean;
	
	@Autowired
	UsrInfoService usrInfoService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LoginUsr loginUsr;
	
	@Autowired 
	private JwtUtil jwtTokenUtil;

	
	@GetMapping("/getAll")
	public String getAll()
	{
		return "Hello";
	}
	
	@PostMapping("/authen")
	public AuthenticatioanResponse createToken(@RequestBody UsrInfo usrInfo) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usrInfo.getUSERNAME(), usrInfo.getPASSWORD()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		final UserDetails userDetails = loginUsr.loadUserByUsername(usrInfo.getUSERNAME()); 
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return new AuthenticatioanResponse(jwt);
	}
	
	

    @GetMapping("/count/{word}")
    public Long getCount(@PathVariable String word){
        final KafkaStreams kafkaStreams =  factoryBean.getKafkaStreams();
        final ReadOnlyKeyValueStore<String, Long> counts = kafkaStreams.store(StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore()));
        return counts.get(word);
    }

}
