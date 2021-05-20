package com.reskill.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reskill.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order,String>{
	public Order findByOrderId(String orderId);

}
