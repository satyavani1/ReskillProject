package com.reskill.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reskill.user.dto.WishlistDTO;
import com.reskill.user.entity.Wishlist;
import com.reskill.user.repository.WishlistRepository;

@Service(value="/wishlist")
@Transactional
public class WishlistService {

	@Autowired
	private WishlistRepository wishlistrepo;
	
	public String addProduct(WishlistDTO wishlist) {
		Wishlist w=new Wishlist();
		w.setBuyerId(wishlist.getBuyerId());
		w.setProdId(wishlist.getBuyerId());
		wishlistrepo.save(w);
		return "product ";
	}

	public String deleteProduct(WishlistDTO wdto) {
		Wishlist w=wishlistrepo.findByBuyerIdAndProdId(wdto.getBuyerId(),wdto.getProdId());
		if(w==null) {
			return "Product not Present";	
	}
		else {
			wishlistrepo.delete(w);
		return "Product delete Successfully";
		}
		
	}
	
}
