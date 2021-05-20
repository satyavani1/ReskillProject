package com.reskill.order.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.reskill.order.dto.OrderDTO;
import com.reskill.order.entity.Order;
import com.reskill.order.service.OrderService;

@RestController
@RequestMapping(value="/orders")
@CrossOrigin
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	Environment environment;
	@GetMapping(value="/order")
	public List<OrderDTO> getAllOrder(){
		return orderService.getAllOrder();
	}
	@GetMapping(value="/order/{orderId}")
	public ResponseEntity<OrderDTO> getSpecificOrders(@PathVariable String orderId){
		ResponseEntity<OrderDTO> responseEntity;
		try {
			OrderDTO orderDTO=orderService.getSpecificOrder(orderId);
			responseEntity=new ResponseEntity<OrderDTO>(orderDTO,HttpStatus.OK);
		}
		catch(Exception e) {
			ResponseStatusException exc=new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
			throw exc;
		}
		return responseEntity;
	}
	@PostMapping(value="/order")
	public String addOrderDetails(@RequestBody Order order) {
		orderService.addOrderDetails(order);
		String str="ADDED SUCCESSFULLY";
		return str;
	}

}
