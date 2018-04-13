package com.tony.dojosninjas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.dojosninjas.models.Ninja;
import com.tony.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}
	
	public void create(Ninja ninja){ninjaRepository.save(ninja);}
	public void update(Ninja ninja){ninjaRepository.save(ninja);}
	public void destroy(long id){ninjaRepository.delete(id);}
	
	public ArrayList<Ninja> all(){
		return (ArrayList<Ninja>) ninjaRepository.findAll();
	}
	
	public Ninja getById(long id){
		return ninjaRepository.findOne(id);
	}
}
