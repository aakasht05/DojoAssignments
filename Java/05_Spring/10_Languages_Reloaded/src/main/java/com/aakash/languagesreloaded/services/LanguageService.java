package com.tony.languagesreloaded.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tony.languagesreloaded.models.Language;
import com.tony.languagesreloaded.repositories.LanguageRepository;

@Service
public class LanguageService{
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}
	
	public ArrayList<Language> all(){
		return (ArrayList<Language>) languageRepository.findAll();
	}
	
	public double count(){
		return languageRepository.count();
	}
	
	public Language getByIndex(long id){
		
			System.out.println(languageRepository.countByNameContaining("Java"));
		//if(id < languageRepository.count()){
			return languageRepository.findOne(id);
		//}
		//return null;
	}
	
	public void create(Language language){
		languageRepository.save(language);
	}
	
	public void update(Language language){
		languageRepository.save(language);
	}
	
	public void destroy(long id){
		//if(id < languageRepository.count()){
			languageRepository.delete(id);
		//}
	}
}
