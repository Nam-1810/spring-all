package com.hqt.demo.dao;



import org.springframework.stereotype.Repository;

import com.hqt.demo.entities.UsrToken;
@Repository
public class UsrTokenDao extends SqlSecsionDao<UsrToken>{
	
	public void createNewToken(UsrToken parameterMap)
	{
		session.insert("mapper.usrTokenMapper.insert", parameterMap);
	};
	
	public void updateToken(UsrToken parameterMap)
	{
		session.update("mapper.usrTokenMapper.update", parameterMap);
	};
	
	public UsrToken getTokenByUsername(String username)
	{
		return session.selectOne("mapper.usrTokenMapper.selectTokenByUsername",username);
		
	}
	/*
	 * void updateToken(String series, String tokenValue, Date lastUsed);
	 * 
	 * PersistentRememberMeToken getTokenForSeries(String seriesId);
	 * 
	 * void removeUserTokens(String username);
	 */
	
	

}
