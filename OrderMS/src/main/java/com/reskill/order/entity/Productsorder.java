package com.reskill.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity
@IdClass(CompositeKey.class)
public class Productsorder {
@Id
 private String buyerId;
@Id
 private String prodId;
 private String sellerId;
 private Integer quantity;
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
public String getSellerId() {
	return sellerId;
}
public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
 
 
 
}
