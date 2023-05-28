package com.weatherapp.WeatherUapp.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class UserAccountDetailsDAOImplementation implements UserAccountDetailsDAO {
	
	private EntityManager entityManager; //An EntityManager object manages a set of entities that are defined by a persistence unit.

	@Autowired
	public UserAccountDetailsDAOImplementation(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public UserAccountDetails saveAccount(UserAccountDetails useraccountdetails) {
		
		UserAccountDetails useraccount=entityManager.merge(useraccountdetails);
		return useraccount;
	}

	@Override
	public UserAccountDetails findbyID(int id) {

		UserAccountDetails useraccountdetails=entityManager.find(UserAccountDetails.class, id);
		return useraccountdetails;
	}

	@Override
	public List<UserAccountDetails> findAll() {

		TypedQuery <UserAccountDetails> query=entityManager.createQuery("FROM UserAccountDetails",UserAccountDetails.class);
		return query.getResultList();
	}

	@Override
	public UserAccountDetails findbyName(String fristName, String LastName) {
		
		Query jpqlQuery=entityManager.createQuery("SELECT * FROM UserAccountDetails WHERE first_name=:fName AND last_name=:lName");
		jpqlQuery.setParameter("fName", fristName).setParameter("lName", LastName);
		return (UserAccountDetails) jpqlQuery.getSingleResult();
	}

	@Override
	public void updateAccessToken(int id, String AccessToken) {
		
		UserAccountDetails account= findbyID(id);
		account.setAccessAPIToken(AccessToken);
		entityManager.merge(account);
	}

	@Override
	public void deletebyID(int id) {
		
		UserAccountDetails account=findbyID(id);
		entityManager.remove(account);
	}

	@Override
	public String getAccessToken(int id) {
		// TODO Auto-generated method stub
		UserAccountDetails account= findbyID(id);
		String accessToken=account.getAccessAPIToken();
		return accessToken;
	}

}
