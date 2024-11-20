package vn.iotstar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.iotstar.entity.User;
import vn.iotstar.repository.IUserRepository;

@Service
public class UserService {
	
	private final IUserRepository userRepository;
	
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User>allUsers(){
		
		List <User> users = new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);
		
		return users;
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	
}
