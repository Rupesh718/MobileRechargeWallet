package com.onlineRecharge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.client.RestTemplate;

import com.onlineRecharge.model.Account;

import com.onlineRecharge.model.Recharge;
import com.onlineRecharge.repository.RechargeReposiory;

@Service
public class RechargeServiceImpl implements RechargeService{

	@Autowired
	private RechargeReposiory rechargeRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Recharge addRecharge(String mobNo, double rechargeAmt,int acc_id) {
		Recharge recharge = null;
		Account acc = getAccountDetails(acc_id);
		if(acc.getMobile_number().equals(mobNo))
		{
			if(acc.getInitial_balance() > rechargeAmt)
			{
				Recharge recObj =new Recharge();
				recObj.setInitialBalance(acc.getInitial_balance()-rechargeAmt);
				recObj.setMobile_number(mobNo);
				recObj.setRechargeAmount(rechargeAmt);
				System.out.println(recObj.getMobile_number());
				System.out.println(recObj.getInitialBalance());
				System.out.println(recObj.getRechargeAmount());
				recharge =rechargeRepo.save(recObj);
			}	
		}
		return recharge;
	}

	
	

	@Override
	public Account getAccountDetails(int acc_id) {
		
		Account acc =restTemplate.getForObject("http://localhost:9091/onlineRecarge/getAccountDetails/"+acc_id, Account.class);
		return acc;
	}

	
	


	@Override
	public List<Recharge> getRechrageDetails() {
     List<Recharge> rech=rechargeRepo.findAll();
		return rech;
	}




	@Override
	public Recharge getRechargeDetailsById(Integer recharge_id) {
		
		return rechargeRepo.findById(recharge_id).get();
	}

}
