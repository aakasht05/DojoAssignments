package com.tony.beltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.beltreviewer.models.Guild;

@Repository
public interface GuildRepository extends CrudRepository<Guild,Long>{

}
