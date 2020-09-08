package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.IDao;
import com.example.dto.Cart;
import com.example.dto.User;
import com.example.validation.NameException;

@Service
public class ServiceImpl implements Iservice{
	
	@Autowired
	IDao dao;
	
	@Override
	public User add(User user) throws NameException {
		User u = dao.add(user);
		if(u == null)
	        throw new NameException("Invalid User");
		return u;
	}

	@Override
	public void addToCart(String mobileNum, Cart cart) {
		// TODO Auto-generated method stub
		dao.addToCart(mobileNum, cart);
		return;
	}


	@Override
	public List<Cart> getCartDetails(String mobileNum) {
		// TODO Auto-generated method stub
		return dao.getCartDetails(mobileNum);
	}

	@Override
	public Cart updateCart(String mobileNum, Cart cart) {
		return dao.updateCart(mobileNum, cart);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(String mobileNum,Cart cart) {
		// TODO Auto-generated method stub
		dao.deleteCart(mobileNum, cart);
		return;
	}


}
