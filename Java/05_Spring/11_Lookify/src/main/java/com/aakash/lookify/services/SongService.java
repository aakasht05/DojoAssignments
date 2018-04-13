package com.tony.lookify.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tony.lookify.models.Song;
import com.tony.lookify.repositories.SongRepository;

@Service
public class SongService{
	private SongRepository songRepository;
	
	public SongService(SongRepository songRepository){
		this.songRepository = songRepository;
	}
	
	public void create(Song song){
		songRepository.save(song);
	}
	
	public void update(Song song){
		songRepository.save(song);
	}
	
	public void destroy(long id){
		songRepository.delete(id);
	}
	
	public ArrayList<Song> all(){
		return (ArrayList<Song>) songRepository.findAll();
	}
	
	public ArrayList<Song> findByArtist(String song){
		return (ArrayList<Song>) songRepository.findByArtistContaining(song);
	}
	
	public Song findById(long id){
		return songRepository.findOne(id);
	}
	
	public ArrayList<Song> top10(){
		ArrayList<Song> songs = (ArrayList<Song>) songRepository.OrderByRatingDesc();
		for(int i=0;i<songs.size();i++){
			if(i > 10){
				songs.remove(i);
			}
		}
		
		return songs;
	}
}
