package com.reskill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reskill.user.dto.CartDTO;
import com.reskill.user.dto.ProductDTO;

import com.reskill.user.service.CartService;


@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class CartController {
	
	@Autowired
	private CartService cartser;

	
//	@Value("${product.uri}")
//	String prodUri;
	
	@PostMapping(value = "/addToCart",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO) {
		String message=cartser.addProduct(cartDTO);
		String m="";
		ProductDTO cdto=new RestTemplate().getForObject("http://localhost:8200/products/products/"+cartDTO.getProdId(), ProductDTO.class);
		if(cdto!=null) {
			m=message+" successfully added in cart";
		}
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	

	@DeleteMapping(value = "/removeProductFromCart")
	public ResponseEntity<String> deleteBuyer(@RequestBody CartDTO cartDTO)  {
		
		String message=cartser.deleteProduct(cartDTO);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
