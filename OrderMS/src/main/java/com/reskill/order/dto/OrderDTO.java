package com.reskill.order.dto;

import java.util.Date;

import com.reskill.order.entity.Order;

public class OrderDTO {
	private String orderId;
	private String buyerId;
	private float amount;
	private Date date;
	private String address;
	
	private String status;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", buyerId=" + buyerId + ", amount=" + amount + ", date=" + date
				+ ", address=" + address + ", status=" + status + "]";
	}
	public static OrderDTO valueOf(Order order) {
		OrderDTO orderDTO=new OrderDTO();
		orderDTO.setAddress(order.getAddress());
		orderDTO.setAmount(order.getAmount());
		orderDTO.setBuyerId(order.getBuyerId());
		orderDTO.setDate(order.getDate());
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setStatus(order.getStatus());
		return orderDTO;
	}
}
