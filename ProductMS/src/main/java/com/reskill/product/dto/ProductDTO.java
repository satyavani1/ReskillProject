package com.reskill.product.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDTO {
	private String prodId;
	@Pattern(regexp="[A-Za-z]+( [A-Za-z0-9]+)*", message="{name.error}")
	private String productName;
	@Min(value=200, message="{price.error}")
	private Float price;
	@Min(value=10, message="{stock.error}")
	private Integer stock;
	@Size(max=500, message="{description.error}")
	private String description;
	@Pattern(regexp="[A-Za-z0-9-]+[.](png|jpeg)", message="{image.error}")
	private String image;
	private String sellerId;
	private String category;
	private String subCategory;
	private Float productRating;
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Float getProductRating() {
		return productRating;
	}
	public void setProductRating(Float productRating) {
		this.productRating = productRating;
	}
	

}
