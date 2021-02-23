package com.smsalert.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsalert.model.User;
import com.smsalert.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository urepo;
	
	// get all user
	
	public List<User> getAllUser()
	{
		
		return urepo.findAll();
	}
	
	// save user
	
	public void saveUser(User user)
	{
	  urepo.save(user);
	}
	
	// delete user
	public void deleteUser(int id)
	{
		urepo.deleteById(id);
	}
	
	//get User By Id
	
	public User getUserById(int id)
	{
		Optional<User> optional=urepo.findById(id);
		User user=null;
		if(optional.isPresent())
		{
			user=optional.get();
		}
		else
		{
		  throw new RuntimeException("User Not Found");
		}
		
		return user;
	}
	
	
}
