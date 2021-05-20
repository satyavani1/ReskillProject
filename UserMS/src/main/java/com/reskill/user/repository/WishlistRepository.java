package com.reskill.user.repository;



import org.springframework.data.repository.CrudRepository;

import com.reskill.user.entity.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist,String>  {

	Wishlist findByBuyerIdAndProdId(String buyerId,String prodId);

}
