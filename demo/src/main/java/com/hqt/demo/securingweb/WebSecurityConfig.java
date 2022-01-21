package com.hqt.demo.securingweb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthenticatedPrincipalOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;


@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean("authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	  
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/webjars/**", "/sysConfig/**","rest/authen","/register");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()      
		        .antMatchers("/anonymous*").anonymous()
				.antMatchers("/oauth_login/*","/graphql/**").permitAll().anyRequest().authenticated()
				
		 .and()
				.formLogin().loginPage("/oauth_login").permitAll()
			
		 .and()
				.logout()
			    .logoutUrl("/logout")
				.logoutSuccessUrl("/oauth_login")
				.permitAll()
		 .and()
				.rememberMe()
				.rememberMeCookieName("remwmber-me-example-cooki")
				.key("uniqueAndSecret").tokenValiditySeconds(60*60*24*7)
		 .and()
		         .oauth2Login()
		         .loginPage("/oauth_login")
		         .failureUrl("/loginFailure")
		         .clientRegistrationRepository(clientRegistrationRepository())
		         .authorizedClientService(authorizedClientService());
	}
	
	
	


	/*---------------- Oauth2 config ------------------*/
	private static List<String> clients = Arrays.asList("google", "github");
	
	
	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
	        List<ClientRegistration> registrations = clients.stream()
	          .map(c -> getRegistration(c))
	          .filter(registration -> registration != null)
	          .collect(Collectors.toList());
	        
	        return new InMemoryClientRegistrationRepository(registrations);
	    }

    private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";
	   
    @Resource
    private Environment env;

	private ClientRegistration getRegistration(String client) {
	        String clientId = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-id");

	        if (clientId == null) {
	            return null;
	        }
	        String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");
	        if (client.equals("google")) {
	            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
	                .clientId(clientId)
	                .clientSecret(clientSecret)
	                .build();
	        }
	        if (client.equals("github")) {
	            return CommonOAuth2Provider.GITHUB.getBuilder(client)
	                .clientId(clientId)
	                .clientSecret(clientSecret)
	                .build();
	        }
	        return null;
	    }

	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
	 
	    return new InMemoryOAuth2AuthorizedClientService(
	      clientRegistrationRepository());
	} 
	
	@Bean
	    public OAuth2AuthorizedClientRepository authorizedClientRepository(
	            OAuth2AuthorizedClientService authorizedClientService) {
	        return new AuthenticatedPrincipalOAuth2AuthorizedClientRepository(authorizedClientService);
	}
}