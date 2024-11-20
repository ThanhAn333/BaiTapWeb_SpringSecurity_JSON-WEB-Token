package vn.iotstar.demo_sitemesh_thymeleaf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.iotstar.demo_sitemesh_thymeleaf.repository.UserInfoRepository;
import vn.iotstar.demo_sitemesh_thymeleaf.config.UserInfoUserDetails;
import vn.iotstar.demo_sitemesh_thymeleaf.entity.UserInfo;
public class UserInfoService implements UserDetailsService {
	@Autowired
	UserInfoRepository reposity;
	public UserInfoService(UserInfoRepository userInfoRepository) {
		this.reposity = userInfoRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	Optional<UserInfo> userInfo = reposity.findByName(username);
	return userInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
	}
}
