package com.onlineRecharge.service;

import java.util.List;

import com.onlineRecharge.model.Account;
import com.onlineRecharge.model.Recharge;


public interface RechargeService {
	
	

	Account getAccountDetails(int acc_id);


	Recharge addRecharge(String mobNo, double rechargeAmt,int acc_id);

	List<Recharge> getRechrageDetails();


	Recharge getRechargeDetailsById(Integer recharge_id);

}
