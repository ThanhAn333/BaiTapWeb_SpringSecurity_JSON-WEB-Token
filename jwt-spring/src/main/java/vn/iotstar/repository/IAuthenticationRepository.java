package vn.iotstar.repository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.iotstar.entity.User;
import vn.iotstar.models.LoginUserModel;
import vn.iotstar.models.RegisterUserModel;

public interface IAuthenticationRepository {	
	public User signup(RegisterUserModel input);
	
	public User authenticate(LoginUserModel input);
}
