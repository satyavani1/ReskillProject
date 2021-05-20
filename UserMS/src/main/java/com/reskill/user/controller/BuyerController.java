package com.reskill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reskill.user.dto.BuyerDTO;
import com.reskill.user.dto.LoginDTO;
import com.reskill.user.service.BuyerService;

@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class BuyerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BuyerService buyerService;
	


	
	@PostMapping(value = "/buyers",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCustomer(@RequestBody BuyerDTO buyDTO) {
		String id=buyerService.createBuyer(buyDTO);
		return new ResponseEntity<>("registered successfully whith id : "+id, HttpStatus.CREATED);
	}
	
	
	@PostMapping(value = "/buyerlogin",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		String m= buyerService.login(loginDTO);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/buyers/{buyerId}")
	public ResponseEntity<String> deleteBuyer(@PathVariable String buyerId)  {
		buyerService.deleteBuyer(buyerId);
		return new ResponseEntity<>("Buyer delete sucessfully", HttpStatus.OK);
	}
	@GetMapping(value = "/allBuyers")
	public ResponseEntity<List<BuyerDTO>> getAllBuyers() {
		List<BuyerDTO> buyerList = buyerService.getAllBuyers();
		return new ResponseEntity<>(buyerList, HttpStatus.OK);
	}

}
