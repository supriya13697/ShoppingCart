package com.example.service;

import java.util.List;

import com.example.dto.Cart;
import com.example.dto.User;
import com.example.validation.NameException;

public interface Iservice {
	
	public User add(User user) throws NameException;
	
    public void addToCart(String mobileNum,Cart cartList);
    public List<Cart> getCartDetails(String mobileNum); 
    public Cart updateCart(String mobileNum, Cart cart);
    public void deleteCart(String mobileNum,Cart cart);

}
