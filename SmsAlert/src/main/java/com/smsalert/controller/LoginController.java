package com.smsalert.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smsalert.Message;

@Controller
public class LoginController {

	

	
	@PostMapping("/dashboard")
	public String userLogin(@RequestParam("name") String name,@RequestParam("password") String password,HttpSession session)
	{
		if(name.equals("rajasp") && password.equals("rajasp123"))
		{
			session.setAttribute("user",name);
			return "dashboard";
		}
		else
	     session.setAttribute("message",new Message("Login Fail try again","alert-danger"));		
		 return "index";
	}
}
