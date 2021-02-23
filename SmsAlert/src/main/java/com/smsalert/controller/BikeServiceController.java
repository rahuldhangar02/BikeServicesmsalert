package com.smsalert.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smsalert.Service.BikeService;
import com.smsalert.helpers.SMSHelper;
import com.smsalert.model.Bike;





@Controller
public class BikeServiceController {

	@Autowired
	private BikeService bservice;
	
	@GetMapping("/serviceview")
	public String viewService(Model model,HttpSession session)
	{
		String name=(String)session.getAttribute("user");
		 if(name!=null)
		 {
			 List<Bike> list=bservice.viewAllBike();
				model.addAttribute("mlist",list);
				return "serviceview";
		 }
		 else
			 return "index";
		
	}
	
	
	 @GetMapping("/service")
	 public String bikeService(HttpSession session)
	 {
		 String name=(String)session.getAttribute("user");
		 if(name!=null)
		 {
			 return"service";
		 }
		 else
			 return "index";
		 
	 }
	 
	 
	 	 
	 /// add Service
	 @PostMapping("/addservice")
	 public String addService(@ModelAttribute("service") Bike service,HttpSession session) throws MalformedURLException, IOException
	 {
		 System.out.println(service.getName()+" >>>>>>>>>>> "+ service.getMobileNo()+">>>>"+service.getVehicleNo());
		 String response=new SMSHelper().Message2(service.getName(), service.getMobileNo(),service.getVehicleNo()); 
         if(response!="")
        	 System.out.println("SMS Delivered");
		 bservice.saveBike(service);
         session.setAttribute("message",new com.smsalert.Message("Service Added Succesfully..","alert-success"));
          
		 return "redirect:/service";
	 }
	   // view Service records by id
	 
	 @GetMapping("/showServiceForm/{id}")
		public String getByBikeId(@PathVariable (value = "id") int id,Model model)
		{
			Optional<Bike> b=bservice.getByBikeId(id);
	       
			model.addAttribute("bike",b);
			
			return "serviceUpdate";
		}
	
		
		/// delete Country Countroller
		
		 @GetMapping("/deleteService/{id}")
		 public String deleteService(@PathVariable (value ="id") int id)
		 {
			 bservice.deleteBikeRecords(id);
			 return "redirect:/serviceview";
		 }
}
