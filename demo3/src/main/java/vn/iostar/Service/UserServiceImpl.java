package vn.iostar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.iostar.Repository.UserRepository;
import vn.iostar.Service.Impl.MyUserService;
import vn.iostar.entity.Users;
@Service
public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException{
		Users user= userRepository.getUserByUsername(username);
		
		if ( user ==null)
		{
			throw new UsernameNotFoundException("Could not dinf user");
		}
		return new MyUserService(user);
	} 
}
