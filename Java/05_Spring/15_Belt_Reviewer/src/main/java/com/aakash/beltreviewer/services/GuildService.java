package com.tony.beltreviewer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tony.beltreviewer.models.Guild;
import com.tony.beltreviewer.repositories.GuildRepository;

@Service
public class GuildService{
	private GuildRepository guildRepository;
	
	public GuildService(GuildRepository guildRepository){
		this.guildRepository = guildRepository;
	}
	
	public void create(Guild guild){guildRepository.save(guild);}
	public void update(Guild guild){guildRepository.save(guild);}
	public void destroy(long id){guildRepository.delete(id);}
	public Guild getById(long id){return guildRepository.findOne(id);}
	public List<Guild> all(){return (List<Guild>) guildRepository.findAll();}
}
