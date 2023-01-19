package com.onlineRecharge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Recharge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recharge_id;

	@NotNull
    @Size(min=10,max=10, message="contact no min and max value 10 digits")
    private String mobile_number;
	
	@NotBlank(message="amount is mandtory")
    private double rechargeAmount;
	
    private double initialBalance;

	public Recharge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recharge(Integer recharge_id,
			@NotNull @Size(min = 10, max = 10, message = "contact no min and max value 10 digits") String mobile_number,
			@NotBlank(message = "amount is mandtory") double rechargeAmount, double initialBalance) {
		super();
		this.recharge_id = recharge_id;
		this.mobile_number = mobile_number;
		this.rechargeAmount = rechargeAmount;
		this.initialBalance = initialBalance;
	}

	public Integer getRecharge_id() {
		return recharge_id;
	}

	public void setRecharge_id(Integer recharge_id) {
		this.recharge_id = recharge_id;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public double getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
    
    
	
	
}
