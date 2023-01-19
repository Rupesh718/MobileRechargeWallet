package com.onlineRecharge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.onlineRecharge.exception.UserNotFoundException;
import com.onlineRecharge.model.Account;

import com.onlineRecharge.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	//@Autowired
	//RestTemplate restTemplate;
	
	@Override
	public Account createAccount(Account account) {
		Account accountObj =accountRepository.save(account);
		return accountObj;
	}

	@Override
	public List<Account> getAccountService() {
	
		List<Account> accountDetails =accountRepository.findAll();
		return accountDetails;
	}


	@Override
	public Account updateAccount(Account account, Integer acc_id) {
		
		Account  accUpdate =accountRepository.findById(acc_id).get();
		accUpdate.setUserName(account.getUserName());
		accUpdate.setPassword(account.getPassword());
		accUpdate.setMobile_number(account.getMobile_number());
				accUpdate.setEmail(account.getEmail());
				accUpdate.setAccount_type(account.getAccount_type());
				accUpdate.setInitial_balance(account.getInitial_balance());
				accountRepository.save(accUpdate);
				return accUpdate;
	}

	@Override
	public Account findById(Integer acc_id) {
		Account accObj =accountRepository.findById(acc_id).orElseThrow((()-> new UserNotFoundException("User not found with id: "+acc_id)));
			
		return accObj;
	}

	@Override
	public void deleteAccountById(Integer acc_id) {
		accountRepository.deleteById(acc_id);
		
	}

	@Override
	public Account loginAccount(Account account) {
		Account accObj =accountRepository.findByEmail(account.getEmail());
		if(accObj.getPassword().equals(account.getPassword())){
		return accObj;
		}
		return null;
	}

	
	
	
	
	
	/*
	 * @Override public Plan getPlanDetails(int planid) {
	 * 
	 * Plan p =restTemplate.getForObject(
	 * "http://localhost:9092/onlineRecharge/getPlanDetails/"+planid, Plan.class);
	 * return p; }
	 */
	}



	 


	
	

