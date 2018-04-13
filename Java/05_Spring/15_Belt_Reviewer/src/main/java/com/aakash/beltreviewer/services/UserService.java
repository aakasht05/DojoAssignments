package com.tony.beltreviewer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tony.beltreviewer.models.Role;
import com.tony.beltreviewer.models.User;
import com.tony.beltreviewer.repositories.RoleRepository;
import com.tony.beltreviewer.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCrypt;
	
	public UserService(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCrypt){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCrypt = bCrypt;
	}
	
	public List<User> all(){return (List<User>) userRepository.findAll();}
	public User getById(long id){return userRepository.findOne(id);}
	public User findByEmail(String email){return userRepository.findByEmail(email);}
	public User findByUsername(String username){return userRepository.findByUsername(username);}
	public List<User> findByEmailList(String email){return userRepository.findByEmailList(email);};
	public List<User> findByUsernameList(String username){return userRepository.findByUsernameList(username);};

	public void create(String[] roles,User user){
		List<Role> userRoles = new ArrayList<>();
		
		for(String role:roles){
			Role getRole = roleRepository.findByName(role);
			if(getRole != null){userRoles.add(getRole);}
		}
				
		user.setPassword(bCrypt.encode(user.getPassword()));
		user.setRoles(userRoles);
		userRepository.save(user);
	}
	public void update(User user){userRepository.save(user);}
	public void destroy(long id){userRepository.delete(id);}
}
