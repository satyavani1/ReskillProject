package com.reskill.product.entity;

import java.io.Serializable;

public class CompositeIDclass implements Serializable{
	private static final long serialVersionUID = 1L;
	private String buyerId;
	private String  prodId;
	
	public CompositeIDclass() {
	}

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
	
}
