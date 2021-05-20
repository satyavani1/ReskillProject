package com.reskill.order.entity;

import java.io.Serializable;

public class CompositeKey implements Serializable {
	private static final long serialVersionUID = 1L;
	 public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	private String buyerId;
	  private String prodId;
}
