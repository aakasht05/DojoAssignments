package com.tony.languagesreloaded.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.languagesreloaded.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long>{
	Long countByNameContaining(String search);
}
