package com.reskill.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reskill.user.dto.BuyerDTO;
import com.reskill.user.dto.LoginDTO;
import com.reskill.user.entity.Buyer;
import com.reskill.user.repository.BuyerRepository;

@Service(value="/buyer")
public class BuyerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	BuyerRepository buyerRepo;
	
	//registration
	public String createBuyer(BuyerDTO buyDTO) {
		logger.info("Creation request for Buyer {}", buyDTO);
		Buyer buy = buyDTO.createEntity();
		buyerRepo.save(buy);
		return buy.getBuyerId();
	}
	
	//login
	public String login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNumber(),loginDTO.getPassword());
		Optional<Buyer> optCust = buyerRepo.findByPhoneNumber(loginDTO.getPhoneNumber());
		if (optCust.isPresent()) {
			Buyer b = optCust.get();
			if (b.getPassword().equals(loginDTO.getPassword())) {
				return "Logged in Successfully";
			}
		}

		return "Invalid Credentials.Please provide the correct credentials";
	}
	
	public void deleteBuyer(String buyerId)  {
		buyerRepo.deleteById(buyerId);
	}

	public List<BuyerDTO> getAllBuyers() {
		
		Iterable<Buyer> buyers = buyerRepo.findAll();
		List<BuyerDTO> bl = new ArrayList<>();
		buyers.forEach(buyer -> {
			BuyerDTO b = new BuyerDTO();
			b.setBuyerId(buyer.getBuyerId());
			b.setEmail(buyer.getEmail());
			b.setName(buyer.getName());
			b.setPhoneNumber(buyer.getPhoneNumber());
			b.setPrivileged(buyer.isPrivileged());
			b.setRewardPoints(buyer.getRewardPoints());
			b.setActive(buyer.isActive());
			bl.add(b);
		});
		
		return bl;
	}
	
	
	
	

}
