package com.reskill.product.service;

import java.util.List;

import com.reskill.product.dto.ProductDTO;
import com.reskill.product.dto.SubscribedProuctDTO;
//import com.reskill.product.entity.Product;

public interface ProductService {
	//common methods for normal buyers and visitors
		List<ProductDTO> viewProducts();
		List<ProductDTO> searchProductsByCategory(String category);
		List<ProductDTO> searchProductsByProductName(String productName);
		
		//extra methods for privileged buyers
		String addProductToSubscribedlist(SubscribedProuctDTO subscribedProductDTO);
		String removeProductFromSubscribedlist(String prodId);
		
		//methods handled by seller
		String addProduct(ProductDTO productDTO) throws Exception;
		String removeProduct(String prodId);
		ProductDTO viewProductByProdId(String prodId);
		List<ProductDTO> viewProductsBySellerId(String sellerId);
		String updateStockAfterOrder(ProductDTO productDTO,Integer quantity);
		String addStockToProducts(ProductDTO productDTO,Integer quantity);
		ProductDTO FindByProdId(String id);
}
