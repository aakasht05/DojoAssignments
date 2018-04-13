package com.tony.dojosninjas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.dojosninjas.models.Dojo;
import com.tony.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService{
	@Autowired
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository){
		this.dojoRepository = dojoRepository;
	}
	
	public void create(Dojo dojo){dojoRepository.save(dojo);}
	public void update(Dojo dojo){dojoRepository.save(dojo);}
	public void destroy(long id){dojoRepository.delete(id);}
	
	public ArrayList<Dojo> all(){
		return (ArrayList<Dojo>) dojoRepository.findAll();
	}
	
	public Dojo getById(long id){
		return dojoRepository.findOne(id);
	}
}
