package com.reskill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.reskill.user.dto.LoginDTO;

import com.reskill.user.dto.SellerDTO;

import com.reskill.user.service.SellerService;

@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class SellerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SellerService sellerService;
	
	@PostMapping(value = "/sellers",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCustomer(@RequestBody SellerDTO sellDTO) {
		logger.info("Creation request for seller {}", sellDTO);
		String id=sellerService.createSeller(sellDTO);
		return new ResponseEntity<>("Registered successfully with id : "+id, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/sellerlogin",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for seller {} with password {}", loginDTO.getPhoneNumber(),loginDTO.getPassword());
		String m= sellerService.login(loginDTO);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/sellers/{sellerId}")
	public ResponseEntity<String> deleteBuyer(@PathVariable String sellerId)  {
		sellerService.deleteSeller(sellerId);
		return new ResponseEntity<>("Seller delete sucessfully", HttpStatus.OK);
	}
	
	@GetMapping(value = "/allSellers")
	public ResponseEntity<List<SellerDTO>> getAllSellers() {
		List<SellerDTO> sellerList = sellerService.getAllSellers();
		return new ResponseEntity<>(sellerList, HttpStatus.OK);
	}
	
	
}
