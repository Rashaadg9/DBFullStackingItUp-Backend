package com.cognixia.jump.dbfullstacking.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class loginForm implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Username cannot be left blank")
	private String username;
	
	@NotBlank(message = "Password cannot be left blank")
	private String password;
	
	public loginForm()
	{}
	
	public loginForm(@NotBlank(message = "Username cannot be left blank") String username,
			@NotBlank(message = "Password cannot be left blank") String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
