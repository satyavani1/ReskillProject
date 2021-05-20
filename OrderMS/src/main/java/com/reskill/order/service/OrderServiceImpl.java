package com.reskill.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reskill.order.dto.OrderDTO;
import com.reskill.order.entity.Order;
import com.reskill.order.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;
	public List<OrderDTO> getAllOrder(){
		List<Order> orders=orderRepository.findAll();
		List<OrderDTO> orderDT=new ArrayList<>();
		for(Order order:orders) {
			OrderDTO orderDTO=OrderDTO.valueOf(order);
			orderDT.add(orderDTO);
		}
		return orderDT;
	}
	public OrderDTO getSpecificOrder(String orderId)throws Exception{
		OrderDTO orderDTO=null;
		try {
			Optional <Order> opt=orderRepository.findById(orderId);
			if(opt.isPresent()) {
				Order order=opt.get();
				orderDTO=OrderDTO.valueOf(order);
			}
			else
			{
				throw new Exception("OrderService.Order_NOT_FOUND");
			}
		}
		catch(Exception e) {
			throw e;
		}
		return orderDTO;
	}
	public String addOrderDetails(Order order) {
		orderRepository.save(order);
		String str="Successfully Added";
		return str;
	}

}
