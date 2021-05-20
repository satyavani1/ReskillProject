package com.reskill.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginDTO {
	@NotNull(message="please provide PhoneNumber")
	@Pattern(regexp="[6-9][0-9]{9}" ,message="PhoneNumber should be a valid Indian mobile number. It can contain only digits and length should be 10.  ")
	long phoneNumber;
	@NotNull(message="please provide Password")
	@Pattern(regexp=".*[A-Z]+.*" ,message="Password must have at least one lowercase, at least one digit. It should also contain a special character.")
	@Pattern(regexp=".*[a-z]+.*" ,message="Password must have at least one uppercase, at least one digit. It should also contain a special character.")
	@Pattern(regexp=".*[0-9]+.*" ,message="Password must have at least one lowercase, at least one uppercase. It should also contain a special character.")
	@Pattern(regexp=".*[!@#$%^&*]+.*" ,message="Password must have at least one lowercase and at least one digit.")
	String password;
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDTO() {
		super();
	}
	@Override
	public String toString() {
		return "LoginDTO [phoneNo=" + phoneNumber + ", password=" + password + "]";
	}

	
}
