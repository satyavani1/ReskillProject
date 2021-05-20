package com.reskill.product.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reskill.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product,String>{
	
	@Query("select P from Product P where P.category = :category")
	public List<Product> findByCategory(String category);
	@Query("select P from Product P where P.productName = :productName")
	public List<Product> findByProductName(String productName);
	@Query("select P from Product P where P.sellerId = :sellerId")
	public List<Product> findBySellerId(String sellerId);
	public Product findByProdId(String prodId);
	

}
