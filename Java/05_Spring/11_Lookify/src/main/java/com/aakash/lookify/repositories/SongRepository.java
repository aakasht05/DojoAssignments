package com.tony.lookify.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song,Long>{
	public ArrayList<Song> findByArtistContaining(String search);
	public ArrayList<Song> OrderByRatingDesc();
}
