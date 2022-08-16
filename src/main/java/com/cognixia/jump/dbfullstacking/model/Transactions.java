package com.cognixia.jump.dbfullstacking.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Table(name ="Transactions")
@Entity
public class Transactions implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="trans_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trans_id;
	
	@Column(name="trans_date")
	@NotBlank(message = "Date cannot be left blank")
	private Date trans_date;
	
	@Column(name="trans_type")
	@NotBlank(message = "Type cannot be left blank")
	private String trans_type;
	
	@Column(name="trans_amount")
	@NotBlank(message = "Amount cannot be left blank")
	@Min(value = 1)
	private Double trans_amount;
	
	@Column(name="uid")
	@NotBlank(message = "User id cannot be left blank")
	private Integer uid;
	
	public Transactions()
	{}
	
	public Transactions(Integer trans_id, @NotBlank(message = "Date cannot be left blank") Date trans_date,
			@NotBlank(message = "Type cannot be left blank") String trans_type,
			@NotBlank(message = "Amount cannot be left blank") @Min(1) Double trans_amount,
			@NotBlank(message = "User_id cannot be left blank") Integer uid) {
		super();
		this.trans_id = trans_id;
		this.trans_date = trans_date;
		this.trans_type = trans_type;
		this.trans_amount = trans_amount;
		this.uid = uid;
	}

	public Integer getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}

	public Date getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(Date trans_date) {
		this.trans_date = trans_date;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public Double getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(Double trans_amount) {
		this.trans_amount = trans_amount;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	
}
