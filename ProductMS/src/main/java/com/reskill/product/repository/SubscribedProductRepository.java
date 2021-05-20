package com.reskill.product.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reskill.product.entity.CompositeIDclass;
import com.reskill.product.entity.SubscribedProduct;

public interface SubscribedProductRepository extends CrudRepository<SubscribedProduct,CompositeIDclass>{
	
	@Query("select S from SubscribedProduct S where S.prodId = :prodId")
	public SubscribedProduct findByProdId(String prodId); 

}
