package com.reskill.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.reskill.user.entity.Buyer;

public class BuyerDTO {
		@NotNull(message="please provide BuyerId")
		private String buyerId;
		@NotNull(message="please provide Name")
		@Pattern(regexp="([A-Za-z])+(\\s[A-Za-z]+)*" ,message="please provide name with valid format.It can contain only alphabets and spaces.")
		private String name;
		@NotNull(message="please provide Email")
		@Pattern(regexp="[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+" ,message="please provide email with valid format.eg: example@exm.com.")
		private String email;
		@NotNull(message="please provide PhoneNumber")
		@Pattern(regexp="[6-9][0-9]{9}" ,message="PhoneNumber should be a valid Indian mobile number. It can contain only digits and length should be 10.  ")
		private long phoneNumber;
		@NotNull(message="please provide Password")
		@Pattern(regexp=".*[A-Z]+.*" ,message="Password must have at least one lowercase, at least one digit. It should also contain a special character.")
		@Pattern(regexp=".*[a-z]+.*" ,message="Password must have at least one uppercase, at least one digit. It should also contain a special character.")
		@Pattern(regexp=".*[0-9]+.*" ,message="Password must have at least one lowercase, at least one uppercase. It should also contain a special character.")
		@Pattern(regexp=".*[!@#$%^&*]+.*" ,message="Password must have at least one lowercase and at least one digit.")
		private String password;
		private boolean isPrivileged;
		private float rewardPoints;
		private boolean isActive;
		public String getBuyerId() {
			return buyerId;
		}
		public void setBuyerId(String buyerId) {
			this.buyerId = buyerId;
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
		public long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public boolean isPrivileged() {
			return isPrivileged;
		}
		public void setPrivileged(boolean isPrivileged) {
			this.isPrivileged = isPrivileged;
		}
		public float getRewardPoints() {
			return rewardPoints;
		}
		public void setRewardPoints(float rewardPoints) {
			this.rewardPoints = rewardPoints;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		
		
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "BuyerDTO [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNumber="
					+ phoneNumber + ", password=" + password + ", isPrivileged=" + isPrivileged + ", rewardPoints="
					+ rewardPoints + ", isActive=" + isActive + "]";
		}
		public Buyer createEntity() {
			Buyer b=new Buyer();
			b.setBuyerId(this.getBuyerId());
			b.setEmail(this.getEmail());
			b.setName(this.getName());
			b.setPhoneNumber(this.getPhoneNumber());
			b.setPrivileged(this.isPrivileged());
			b.setRewardPoints(this.getRewardPoints());
			b.setActive(this.isActive());
			return b;
		}

	}



