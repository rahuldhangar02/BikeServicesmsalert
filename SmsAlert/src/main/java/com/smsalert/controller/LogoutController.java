package com.smsalert.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.smsalert.Message;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("user");
		session.setAttribute("message",new Message("Logout Succesfully..","alert-success"));
		
		return "index";
	}
}
