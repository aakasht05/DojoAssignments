package com.tony.beltreviewer.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tony.beltreviewer.models.Ring;
import com.tony.beltreviewer.repositories.RingRepository;

@Transactional
@Service
public class RingService{
	private RingRepository ringRepository;
	
	public RingService(RingRepository ringRepository){
		this.ringRepository = ringRepository;
	}
	
	public void create(Ring ring){ringRepository.save(ring);}
	public void update(Ring ring){ringRepository.save(ring);}
	public void destroy(long id){ringRepository.delete(id);}
	public List<Ring> all(){return (List<Ring>) ringRepository.findAll();}
	public Ring getById(long id){return ringRepository.findOne(id);}
	public List<Object[]> ringsNotPickedUp(){return ringRepository.ringsNotPickedUp();}
	public int deleteRingWhere(Long id){return ringRepository.deleteRingWhere(id);}
}
