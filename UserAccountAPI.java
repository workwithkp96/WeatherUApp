package com.weatherapp.WeatherUapp.RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.WeatherUapp.Entity.UserAccountDetails;
import com.weatherapp.WeatherUapp.Service.UserAccountDetailsService;

@RestController
@RequestMapping("/api")
public class UserAccountAPI {
	
	private UserAccountDetailsService useraccountdetailsservice;

	@Autowired
	public UserAccountAPI(UserAccountDetailsService useraccountdetailsservice) {
		super();
		this.useraccountdetailsservice = useraccountdetailsservice;
	}
	
	
	//REST API for saving a new user account
	@PostMapping("/useraccount")
	public UserAccountDetails saveUserAccount(@RequestBody UserAccountDetails useraccount)
	{
		useraccount.setId(0);
		return useraccountdetailsservice.saveAccount(useraccount);
	}
	
	
	//REST API for retrieving an user account by its account id
	@GetMapping("/useraccount/{useraccount_id}")
	public UserAccountDetails getUserAccountByID(@PathVariable int useraccount_id)
	{
		UserAccountDetails useraccount=useraccountdetailsservice.findbyID(useraccount_id);
		if(useraccount==null)
			throw new RuntimeException("UserAccount id " + useraccount_id + " does not exist.");
		
		return useraccount;
	}
	
	@GetMapping("/useraccount/{user_id}")
	public String getAccessToken(@PathVariable int user_id)
	{
		UserAccountDetails useraccount=useraccountdetailsservice.findbyID(user_id);
		if(useraccount==null)
			throw new RuntimeException("UserAccount id " + user_id + " does not exist.");
		
		String accessToken=useraccountdetailsservice.getAccessToken(user_id);
		return accessToken;
	}
	
	//REST API to obtain all the user accounts
	@GetMapping("/useraccount")
	public List<UserAccountDetails> getUserAccounts()
	{
		return useraccountdetailsservice.findAll();
	}
	
	
	//REST APIto obtain an user account by its name
	@GetMapping("/useraccount/{firstName}/&{lastname}")
	public UserAccountDetails getUserAccountByName(@PathVariable String firstName, @PathVariable String lastName)
	{
		UserAccountDetails useraccount=useraccountdetailsservice.findbyName(firstName, lastName);
		if(useraccount==null)
			throw new RuntimeException("UserAccount does not exist with name "+firstName + " " +lastName);
		
		return useraccount;
	}
	
	
	//REST API to update the access token for a particular id
	@PutMapping("/useraccount/{useraccount_id}")
	public String updateAccessToken(@PathVariable int useraccount_id,@RequestBody String AccessToken) throws Throwable
	{
		UserAccountDetails useraccount=useraccountdetailsservice.findbyID(useraccount_id);
		if(useraccount==null)
			throw new RuntimeException("User Account "+ useraccount_id + " does not exist ");
		
		useraccountdetailsservice.updateAccessToken(useraccount_id, AccessToken);
		return "Access Token updated";
	}
	
	
	//REST API to delete the user account of a given id
	@DeleteMapping("/useraccount/{useraccount_id}")
	public String deleteUserAccountByID(@PathVariable int useraccount_id)
	{
		
		UserAccountDetails useraccount=useraccountdetailsservice.findbyID(useraccount_id);
		if(useraccount==null)
			throw new RuntimeException("User Account "+ useraccount_id + " does not exist ");
		
		
		useraccountdetailsservice.deletebyID(useraccount_id);
		return "User Account " + useraccount_id + " successfully deleted";
	}

}
