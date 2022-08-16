package com.cognixia.jump.dbfullstacking.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class cashUpdate implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Id cannot be left blank")
	private Integer id;
	
	@NotBlank(message = "Id cannot be left blank")
	private String type;
	
	@Min(1)
	private double amount;
	
	public cashUpdate()
	{}

	public cashUpdate(@NotBlank Integer id, @NotBlank String type, @Min(1) double amount) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "cashUpdate [id=" + id + ", type=" + type + ", amount=" + amount + "]";
	}
	
	
}
