package com.reskill.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.reskill.user.entity.Seller;

public class SellerDTO {
	@NotNull(message="please provide SellerId")
	private String sellerId;
	@NotNull(message="please provide Name")
	@Pattern(regexp="([A-Za-z])+(\\s[A-Za-z]+)*" ,message="please provide name with valid format.It can contain only alphabets and spaces.")
	private String name;
	@NotNull(message="please provide Email")
	@Pattern(regexp="[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+" ,message="please provide email with valid format.eg: example@exm.com.")
	private String email;
	@NotNull(message="please provide PhoneNumber")
	@Pattern(regexp="[6-9][0-9]{9}" ,message="PhoneNumber should be a valid Indian mobile number. It can contain only digits and length should be 10.  ")
	private String phoneNumber;
	@NotNull(message="please provide Password")
	@Pattern(regexp=".*[A-Z]+.*" ,message="Password must have at least one lowercase, at least one digit. It should also contain a special character.")
	@Pattern(regexp=".*[a-z]+.*" ,message="Password must have at least one uppercase, at least one digit. It should also contain a special character.")
	@Pattern(regexp=".*[0-9]+.*" ,message="Password must have at least one lowercase, at least one uppercase. It should also contain a special character.")
	@Pattern(regexp=".*[!@#$%^&*]+.*" ,message="Password must have at least one lowercase and at least one digit.")
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
	@Override
	public String toString() {
		return "SellerDTO [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", isActive=" + isActive + "]";
	}
	public Seller createEntity() {
	   Seller s=new Seller();
	   s.setActive(this.isActive());
	   s.setEmail(this.getEmail());
	   s.setName(this.getName());
	   s.setPassword(this.getPassword());
	   s.setPhoneNumber(this.getPhoneNumber());
	   s.setSellerId(this.getSellerId());
	     return s;
	}

}

