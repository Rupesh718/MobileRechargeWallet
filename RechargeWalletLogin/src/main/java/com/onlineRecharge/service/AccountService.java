package com.onlineRecharge.service;

import java.util.List;
import java.util.Optional;


import com.onlineRecharge.model.Account;


public interface AccountService {
	public Account createAccount(Account account);

	public List<Account> getAccountService();

	//public Account updateAccount(Account account);

	Account updateAccount(Account account, Integer acc_id);
	
	public Account findById(Integer acc_id);
	
	void deleteAccountById(Integer acc_id);

	public Account loginAccount(Account account);

	//public Plan getPlanDetails(int planid);
	
}
