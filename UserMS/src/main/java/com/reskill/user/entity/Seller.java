package com.reskill.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller {

@Id
private String sellerId;
private String name;
private String email;
private String phoneNumber;
private String password;
private boolean isActive;
public String getSellerId() {
	return sellerId;
}
public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}



}
