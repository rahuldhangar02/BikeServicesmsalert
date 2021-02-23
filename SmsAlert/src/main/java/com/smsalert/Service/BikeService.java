package com.smsalert.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsalert.model.Bike;
import com.smsalert.repository.BikeRepository;

@Service
public class BikeService {

	@Autowired
	private BikeRepository brepo;
	
	// list all data
	public List<Bike> viewAllBike()
	{
		return brepo.findAll();
	}
	
	// add bike data
	
	public void saveBike(Bike bike)
	{
		brepo.saveAndFlush(bike);
	}
	// get data by id
	public Optional<Bike> getByBikeId(int id)
	{
		
		return brepo.findById(id);
	}
	
	// delete records
	
	public void deleteBikeRecords(int id)
	{
		
		brepo.deleteById(id);
	}
}
