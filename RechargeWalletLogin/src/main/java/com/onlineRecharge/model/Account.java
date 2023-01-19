package com.onlineRecharge.model;

import jakarta.annotation.Resource;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer account_id;
	
	@NotBlank(message="name is mandtory")
	private String userName;
	
	@NotBlank(message="password is mandtory")
	private String password;
	
	@NotNull
    @Size(min=10,max=10, message="contact no min and max value 10 digits")
	private String mobile_number;
	
	@Email(message="not in format of email")
	private String email;
	
	@NotBlank(message = "name is mandtory")
	private String account_type;
	
	@NotNull
	private double initial_balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer account_id, @NotBlank(message = "name is mandtory") String userName,
			@NotBlank(message = "password is mandtory") String password,
			@NotNull @Size(min = 10, max = 10, message = "contact no min and max value 10 digits") String mobile_number,
			@Email(message = "not in format of email") String email,
			@NotBlank(message = "name is mandtory") String account_type, @NotNull double initial_balance) {
		super();
		this.account_id = account_id;
		this.userName = userName;
		this.password = password;
		this.mobile_number = mobile_number;
		this.email = email;
		this.account_type = account_type;
		this.initial_balance = initial_balance;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getInitial_balance() {
		return initial_balance;
	}

	public void setInitial_balance(double initial_balance) {
		this.initial_balance = initial_balance;
	}

	
	
	
	
  
}
