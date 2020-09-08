package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.dto.Cart;
import com.example.dto.User;
import com.example.service.Iservice;

@Controller
@RequestMapping("/shoppingCart")
public class MyController {
	    
	@Autowired
	private Iservice service;
		
	@RequestMapping("/login")
	public String add(User user) {
		return "loginpage";
	}
	
	@PostMapping("/userLogin")
	public String addUser(User user,Model m)  {
		service.add(user);
		m.addAttribute("uName", user.getuName());
		return "loginSuccess";
	}
	
	@RequestMapping("/mobileNo")
	public String getMobileNo(String mobileNo, Model m) {
		m.addAttribute("mobileNo", mobileNo);
		return "userSelection";
	}
	
	@RequestMapping("/cartDetails")
	public String addUserSelection(String mobileNo, Model m) {
		m.addAttribute("mobileNo", mobileNo);
		return "items";
	}
	
	@RequestMapping("/items")
	public String itemCount(@RequestParam(name = "items") String items, String mobileNo, Model m) {
		m.addAttribute("mobileNo", mobileNo);
		m.addAttribute("items", items);
		System.out.println(items);
		return "cartpage";
	}
	
	@PostMapping("/cartpage")
	public String addToCart(Cart carts, String mobileNo, Model m) {
		service.addToCart(mobileNo,carts);
		m.addAttribute("mobileNo", mobileNo);
		return "success";
	}
	
	@PostMapping("/addAll")
	public String addAll(List<Cart> cart, String mobileNo, Model m) {
		return "";
	}
	
	@RequestMapping("/displayCartInfo")
	public String getCartDetails(String mobileNo, Model m) {
		List<Cart> c = service.getCartDetails(mobileNo);
		m.addAttribute("c",c);
		m.addAttribute("mobileNo", mobileNo);
		return "display";
	}
	
	@PostMapping("/update")
	public String updatepage(@ModelAttribute("updateList") ArrayList<Cart> updateList,Cart cart,Cart cart1, String mobileNo, Model m) {
		System.out.println("test1"+cart1);
		System.out.println("test"+cart);
		System.out.println("cart"+m.getAttribute("cart"));
		System.out.println("c"+m.getAttribute("cart1"));
		System.out.println("list"+m.getAttribute("updateList"));
		System.out.println("new:"+updateList);
		Cart updatecart = service.updateCart(mobileNo, cart);
		m.addAttribute("mobileNo", mobileNo);
		return "update";
	}
	
	
	@RequestMapping("/delete")
	public String deletepage(Cart cart, String mobileNo, Model m) {
		service.deleteCart(mobileNo, cart); 
		m.addAttribute("mobileNo", mobileNo);
		return "delete";
	}
}
