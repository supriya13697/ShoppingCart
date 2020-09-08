package com.example.dto;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mobileNo;
	private String product;
	private String price;
	private String quantity;
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public Cart(String product, String price, String quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [mobileNo=" + mobileNo + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
}
