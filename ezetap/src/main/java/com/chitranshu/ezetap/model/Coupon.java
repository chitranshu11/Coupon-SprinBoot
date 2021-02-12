package com.chitranshu.ezetap.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private Long amount;
	private String imageLink;
	private Date expiryDate;
	private String couponCode;
	
//	public Coupon(String name, Long amount, String imageLink, Date expiryDate, String couponCode) {
//		this.name = name;
//		this.amount = amount;
//		this.imageLink = imageLink;
//		this.expiryDate = expiryDate;
//		this.couponCode = couponCode;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imgLink) {
		this.imageLink = imgLink;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
}
