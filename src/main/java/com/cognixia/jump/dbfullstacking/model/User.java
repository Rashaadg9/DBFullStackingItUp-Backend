package com.cognixia.jump.dbfullstacking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Table(name ="User")
@Entity
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="first_name")
	@NotBlank(message = "First name cannot be left blank")
	private String first_name;
	
	@Column(name="last_name")
	@NotBlank(message = "Last name cannot be left blank")
	private String last_name;
	
	@Column(name="username")
	@NotBlank(message = "Username cannot be left blank")
	private String username;
	
	@Column(name="pass")
	@NotBlank(message = "Password cannot be left blank")
	private String pass;
	
	@Column(name="pin")
	@NotBlank(message = "Pin cannot be left blank")
	private String pin;
	
	@Column(name="cash")
	@Min(value = 1)
	private Double cash;
	
	public User()
	{}
	
	public User(Integer userId, @NotBlank(message = "First name cannot be left blank") String first_name,
			@NotBlank(message = "Last name cannot be left blank") String last_name,
			@NotBlank(message = "Username cannot be left blank") String username,
			@NotBlank(message = "Password cannot be left blank") String pass,
			@NotBlank(message = "Pin cannot be left blank") String pin,
			@Min(1)Double cash) {
		super();
		this.userId = userId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.pass = pass;
		this.pin = pin;
		this.cash = cash;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}
	
	
}
