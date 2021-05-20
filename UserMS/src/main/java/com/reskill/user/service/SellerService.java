package com.reskill.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.reskill.user.dto.LoginDTO;
import com.reskill.user.dto.SellerDTO;

import com.reskill.user.entity.Seller;

import com.reskill.user.repository.SellerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(value="/seller")
public class SellerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SellerRepository sellerRepo;
	
	
	public String createSeller(SellerDTO sellerDTO) {
		logger.info("Creation request for Seller {}", sellerDTO);
		Seller sell= sellerDTO.createEntity();
		sellerRepo.save(sell);
		return sell.getSellerId();
	}
	
	
	public String login(LoginDTO loginDTO) {
		logger.info("Login request for sellerr {} with password {}", loginDTO.getPhoneNumber(),loginDTO.getPassword());
		Optional<Seller> optCust = sellerRepo.findByPhoneNumber(loginDTO.getPhoneNumber());
		if (optCust.isPresent()) {
			Seller s = optCust.get();
			if (s.getPassword().equals(loginDTO.getPassword())) {
				return "Logged in successfully";
			}
		}

		return "Invalid Credentials.Please provide the correct credentials";
	}


	public void deleteSeller(String sellerId) {
		sellerRepo.deleteById(sellerId);
		
	}


	public List<SellerDTO> getAllSellers() {
		Iterable<Seller> sellers = sellerRepo.findAll();
		List<SellerDTO> sl= new ArrayList<>();
		sellers.forEach(seller -> {
			SellerDTO s = new SellerDTO();
			 s.setActive(seller.isActive());
			   s.setEmail(seller.getEmail());
			   s.setName(seller.getName());
			   s.setPassword(seller.getPassword());
			   s.setPhoneNumber(seller.getPhoneNumber());
			   s.setSellerId(seller.getSellerId());
		});
		
		return sl;
	}
	
	

}
