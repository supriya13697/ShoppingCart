package com.example.dao;

import java.util.List;
import com.example.dto.Cart;
import com.example.dto.User;

public interface IDao {
	public User add(User user);	
    public List<Cart> getCartDetails(String mobileNum);
    public void addToCart(String mobileNum,Cart cartList);
    public Cart updateCart(String mobileNum, Cart cart);
	public void deleteCart(String mobileNum,Cart cart);

}
