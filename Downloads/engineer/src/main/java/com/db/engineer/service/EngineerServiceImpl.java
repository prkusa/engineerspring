package com.db.engineer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.engineer.jpa.EngineerRepo;
import com.db.engineer.model.EngineerModel;

@Service
public class EngineerServiceImpl implements EngineerService{
    
	@Autowired
	EngineerRepo eRepo;
	@Override
	public void save(EngineerModel eml) {
		// TODO Auto-generated method stub
		eRepo.save(eml);
	}
	
	public List<EngineerModel> getAll()
	{
		return eRepo.findAll();
	}

	@Override
	public EngineerModel getEnggById(Long id) {
		// TODO Auto-generated method stub
		EngineerModel eml = eRepo.getById(id);
		
		return eml;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		eRepo.deleteById(id);
		
	}

}
