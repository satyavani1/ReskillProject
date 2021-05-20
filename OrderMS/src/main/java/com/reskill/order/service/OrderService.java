package com.reskill.order.service;

import java.util.List;

import com.reskill.order.dto.OrderDTO;
import com.reskill.order.entity.Order;

public interface OrderService {
	public List<OrderDTO> getAllOrder();
	public OrderDTO getSpecificOrder(String orderId)throws Exception;
	public String addOrderDetails(Order order);
	

}
