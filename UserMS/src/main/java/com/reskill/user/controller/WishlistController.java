package com.reskill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.reskill.user.dto.ProductDTO;
import com.reskill.user.dto.WishlistDTO;
import com.reskill.user.service.WishlistService;

@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class WishlistController {
	
	@Autowired
	private WishlistService wishlistser;

	
//	@Value("${product.uri}")
//	String prodUri;
	
	@PostMapping(value = "/addToWishlist",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToWishlist(@RequestBody WishlistDTO wishlistDTO) {
		String message=wishlistser.addProduct(wishlistDTO);
		String m="";
		ProductDTO pdto=new RestTemplate().getForObject("http://localhost:8200/products/products/"+wishlistDTO.getProdId(), ProductDTO.class);
		if(pdto!=null) {
			m=message+"successfully added in cart";
		}
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/removeProductFromWishList")
	public ResponseEntity<String> deleteBuyer(@RequestBody WishlistDTO wishlistDTO)  {
		
		String message=wishlistser.deleteProduct(wishlistDTO);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
