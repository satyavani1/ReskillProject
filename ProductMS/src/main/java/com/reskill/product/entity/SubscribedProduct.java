package com.reskill.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
	@Entity
	@IdClass(CompositeIDclass.class)
	@Table(name="SUBSCRIBEDPRODUCT")
	public class SubscribedProduct {
		@Id
		private String buyerId;
		@Id
		private String prodId;
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
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		

	}
	

