package com.hqt.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.hqt.demo.entities.UsrInfo;
import com.hqt.demo.entities.SysMenu;
import com.hqt.demo.service.SysMenuService;
import com.hqt.demo.service.UsrInfoService;

@Controller
public class PageController {

	static String authorizationRequestBaseUri = "oauth2/authorization";
	
	@Autowired
	SysMenuService sysMenuService;

	@Autowired
	UsrInfoService usr_infoService;
	
	@Lazy
	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;

	@Lazy
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
	
	Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
	
	@GetMapping("/oauth_login")
	public String login(Model model) {
		if (isAuthenticated()) {
	        return "redirect:/home";
	    }
		List<String> clients = Arrays.asList("google", "github");
		for(int i = 0; i < clients.size(); i++)
		{
			oauth2AuthenticationUrls.put(clientRegistrationRepository.findByRegistrationId(clients.get(i)).getClientName(), authorizationRequestBaseUri + "/" + clientRegistrationRepository.findByRegistrationId(clients.get(i)).getRegistrationId());
		}
		model.addAttribute("urls", oauth2AuthenticationUrls);
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
		
			OAuth2AuthorizedClient client = authorizedClientService
					.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

			String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
					.getUri();

			if (!StringUtils.isEmpty(userInfoEndpointUri)) {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());

				HttpEntity<String> entity = new HttpEntity<String>("", headers);

				ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity,
						Map.class);
				Map userAttributes = response.getBody();
				System.out.println(userAttributes);
				model.addAttribute("name", userAttributes.get("name"));
			}

		return "loginSuccess";
	}
	
	@GetMapping(value = {"","/","/home"})
	public String dashboard(Model model) {
		List<SysMenu> listParent = sysMenuService.selectMenuParent();
		Map<String, List<SysMenu>> map = new HashMap<String, List<SysMenu>>();
		for(int i = 0; i < listParent.size(); i++)
		{
			List<SysMenu> listChild = sysMenuService.selectMenuChild(listParent.get(i).getId());
			map.put(listParent.get(i).getMenu_name(), listChild);
		}
		model.addAttribute("mapMenu", map);
		return "home";
	}
	
	@GetMapping("/sysConfig")
	public String sysConfig() {
		return "sysConfig";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		List<UsrInfo> list = usr_infoService.findAll();
		model.addAttribute("listUser", list);
		model.addAttribute("usrInfo", new UsrInfo());
		return "user";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	
	private boolean isAuthenticated() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || AnonymousAuthenticationToken.class.
	      isAssignableFrom(authentication.getClass())) {
	        return false;
	    }
	    return authentication.isAuthenticated();
	}
}
