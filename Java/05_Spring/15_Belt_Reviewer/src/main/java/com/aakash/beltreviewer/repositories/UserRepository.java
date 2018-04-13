package com.tony.beltreviewer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tony.beltreviewer.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	public User findByEmail(String email);
	public User findByUsername(String username);
	
	@Query(value="SELECT * FROM user WHERE user.email = ?1",nativeQuery=true)
	public List<User> findByEmailList(String email);
	
	@Query(value="SELECT * FROM user WHERE user.username = ?1",nativeQuery=true)	
	public List<User> findByUsernameList(String username);
}
