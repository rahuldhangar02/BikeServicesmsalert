package com.smsalert.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smsalert.Message;
import com.smsalert.Service.UserService;
import com.smsalert.model.User;

@Controller
public class UserController {

	 @Autowired
	private UserService uservice;
	
	@GetMapping("/user")
	public String userPage(Model model,HttpSession session)
	{
		String name=(String)session.getAttribute("user");
		if(name!=null)
		{
			List<User> user=uservice.getAllUser();
			model.addAttribute("mlist",user);
			return "user";
		}
		else
			return "index";
	}
	
	@PostMapping("adduser")
	public String  saveUser(@ModelAttribute("user") User user,HttpSession session)
	{
		uservice.saveUser(user);
		session.setAttribute("message", new Message("User Added Succesfully...","alert-success"));
		return "redirect:/user";
	}
	
	
}
