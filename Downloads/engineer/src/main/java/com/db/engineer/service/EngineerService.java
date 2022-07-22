package com.db.engineer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.engineer.model.EngineerModel;

@Service
public interface EngineerService {
	
	public void save(EngineerModel eml);
	public List<EngineerModel> getAll();
	public EngineerModel getEnggById(Long id);
	public void deleteById(Long id);

}
