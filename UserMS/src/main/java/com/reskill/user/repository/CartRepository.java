package com.reskill.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.reskill.user.entity.Cart;



public interface CartRepository extends CrudRepository<Cart,String> {

	Cart findByBuyerIdAndProdId(String buyerId, String prodId);

}
