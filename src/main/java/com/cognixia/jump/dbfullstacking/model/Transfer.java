package com.cognixia.jump.dbfullstacking.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Transfer implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Your id cannot be left blank")
	private Integer id;
	
	@NotBlank(message = "Other Username cannot be left blank")
	private String username;
	
	@Min(1)
	private Double amount;
	
	public Transfer()
	{}
	
	public Transfer(@NotBlank(message = "Your id cannot be left blank") Integer id,
			@NotBlank(message = "Other Username cannot be left blank") String username, @Min(1) Double amount) {
		super();
		this.id = id;
		this.username = username;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
