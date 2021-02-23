package com.smsalert.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsalert.model.Mecanic;
import com.smsalert.repository.MecanicRepository;

@Service
public class MecanicService {

	@Autowired
	private MecanicRepository repo;
	
	/// view all mecanic
	
	public List<Mecanic> getAllMecanic()
	{
		return repo.findAll();
		
	}
	
	/// save all user
	
	public void saveMecanic(Mecanic m)
	{
		repo.save(m);
	}
	
	// get user
	
	Optional<Mecanic> getMecanicById(int id)
	{
		return repo.findById(id);
	}
	
}
