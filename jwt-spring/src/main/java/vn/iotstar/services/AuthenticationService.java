package vn.iotstar.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.User;
import vn.iotstar.models.LoginUserModel;
import vn.iotstar.models.RegisterUserModel;
import vn.iotstar.repository.IUserRepository;

@Service
public class AuthenticationService {
	
	private final IUserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(IUserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

	public User signup(RegisterUserModel input) {
		User user = new User();
		user.setFullName(input.getFullName());
		user.setEmail(input.getEmail());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		user.setImages(input.getImages());
		return userRepository.save(user);
	}
	
	public User authenticate(LoginUserModel input) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
		return userRepository.findByEmail(input.getEmail()).orElseThrow();
	}
}
