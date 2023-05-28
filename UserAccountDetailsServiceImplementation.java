package com.weatherapp.WeatherUapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weatherapp.WeatherUapp.Entity.UserAccountDetails;
import com.weatherapp.WeatherUapp.Entity.UserAccountDetailsDAO;

import jakarta.transaction.Transactional;

public class UserAccountDetailsServiceImplementation implements UserAccountDetailsService{
	
	private UserAccountDetailsDAO useraccountdetailsdao;

	@Autowired
	public UserAccountDetailsServiceImplementation(UserAccountDetailsDAO useraccountdetailsdao) {
		super();
		this.useraccountdetailsdao = useraccountdetailsdao;
	}

	@Override
	@Transactional
	public UserAccountDetails saveAccount(UserAccountDetails useraccountdetails) {

		UserAccountDetails useraccount=useraccountdetailsdao.saveAccount(useraccountdetails);
		return useraccount;
	}

	@Override
	public UserAccountDetails findbyID(int id) {
		// TODO Auto-generated method stub
		
		UserAccountDetails useraccount = useraccountdetailsdao.findbyID(id);
		return useraccount;
	}

	@Override
	public List<UserAccountDetails> findAll() {
		// TODO Auto-generated method stub
		
		List<UserAccountDetails> useraccounts = useraccountdetailsdao.findAll();
		return useraccounts;
	}

	@Override
	public UserAccountDetails findbyName(String fristName, String LastName) {
		
		UserAccountDetails useraccount = useraccountdetailsdao.findbyName(fristName,LastName);
		return useraccount;
	}

	@Override
	@Transactional
	public void updateAccessToken(int id, String AccessToken) {
		
		useraccountdetailsdao.updateAccessToken(id, AccessToken);
	}

	@Override
	@Transactional
	public void deletebyID(int id) {
		
		useraccountdetailsdao.deletebyID(id);
		
	}

	@Override
	public String getAccessToken(int id) {
		// TODO Auto-generated method stub
		String accessToken=useraccountdetailsdao.getAccessToken(id);
		return accessToken;
	}

}
