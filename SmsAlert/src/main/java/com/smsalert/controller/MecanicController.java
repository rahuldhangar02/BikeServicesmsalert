package com.smsalert.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smsalert.Service.MecanicService;
import com.smsalert.model.Mecanic;

@Controller
public class MecanicController {

	@Autowired
	private MecanicService mservice;
	
	@GetMapping("/mecanic")
	public String viewMecanic(Model model,HttpSession session)
	{
		String name=(String)session.getAttribute("user");
		if(name!=null)
		{
			List<Mecanic> list=mservice.getAllMecanic();
			model.addAttribute("mlist",list);
			return "mecanic";
		}
		else
			return "index";
		
	}
	
	@PostMapping("/addmecanic")
	public String saveMecanic(@ModelAttribute("mecanic") Mecanic mecanic,HttpSession session)
	{
		    mservice.saveMecanic(mecanic);
		    session.setAttribute("message",new com.smsalert.Message("Mecanic Added Succesfully..","alert-success"));
		return "redirect:/mecanic";
	}
}
