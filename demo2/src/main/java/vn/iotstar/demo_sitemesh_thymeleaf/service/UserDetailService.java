package vn.iotstar.demo_sitemesh_thymeleaf.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
