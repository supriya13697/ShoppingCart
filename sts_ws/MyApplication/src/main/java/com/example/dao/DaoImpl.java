package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.dto.Cart;
import com.example.dto.User;
import com.example.util.CommonUtil;

@Repository
public class DaoImpl implements IDao {

	@Autowired
	CommonUtil commonutil;

	Map<String, String> map;
	Map<String, List<Cart>> cartMap = new HashMap<>();
	List<Cart> addList = new ArrayList<>();  
	Cart cart;

	//HardCoded User Login Details
	public DaoImpl() {
		map = new HashMap<String, String>();
		map.put("Supriya", "priya@1997");
		map.put("Chinnu", "chinnu@123");
		map.put("Bannu", "bannu@987");
	}

	@Override
	public User add(User user) {
		for (Map.Entry<String,String> entry : map.entrySet())  {
			if((entry.getKey().equalsIgnoreCase(user.getuName())) && (entry.getValue().equalsIgnoreCase(user.getPassword()))) 
				return user;
		}
		return null;
	}

	@Override
	public void addToCart(String mobileNum, Cart cart) {
		cartMap = commonutil.readData();
		if(!addList.isEmpty()) {
			boolean flag = false;
			for(Cart c: addList) {
				if(c.getProduct().equalsIgnoreCase(cart.getProduct()) && c.getPrice().equalsIgnoreCase(cart.getPrice())) {
					int quantity = Integer.parseInt(c.getQuantity()) + Integer.parseInt(cart.getQuantity());
					c.setQuantity(""+quantity);
					flag = true;
				}
			}
			if(!flag)
				addList.add(cart);
		}
		else
			addList.add(cart);
		cartMap.put(mobileNum, addList);
		commonutil.writeData(cartMap);
	}

	@Override
	public List<Cart> getCartDetails(String mobileNum) {
		if(cartMap.containsKey(mobileNum))
			return cartMap.get(mobileNum);
		return null;


	}

	@Override
	public Cart updateCart(String mobileNum, Cart cart) {
		cartMap = commonutil.readData();
		int index;
		System.out.println(cart);
		for(Cart c: addList) {  
			boolean flag = false;
			index = addList.indexOf(c);
			if(c.getProduct().equalsIgnoreCase(cart.getProduct()) && c.getPrice().equalsIgnoreCase(cart.getPrice())) {
				   int quantity = Integer.parseInt(c.getQuantity()) + Integer.parseInt(cart.getQuantity());
				   c.setQuantity(Integer.toString(quantity));	 
				   addList.remove(index);
				flag = true;
			}
			else if(c.getProduct().equalsIgnoreCase(cart.getProduct())) {
				addList.set(index, cart);
			}
		}
		cartMap.put(mobileNum, addList);
		commonutil.writeData(cartMap);
		return null;
	}

	@Override
	public void deleteCart(String mobileNum,Cart cart) {
		for(Cart c: addList) {
			if(c.getMobileNo().equalsIgnoreCase(cart.getMobileNo()) && c.getProduct().equalsIgnoreCase(cart.getProduct())
					&& c.getPrice().equalsIgnoreCase(cart.getPrice()) && c.getQuantity().equalsIgnoreCase(cart.getQuantity())) {
				int index = addList.indexOf(c);
				addList.remove(index);
				cartMap.put(mobileNum, addList);
			}
		}
		return;
	}
}
