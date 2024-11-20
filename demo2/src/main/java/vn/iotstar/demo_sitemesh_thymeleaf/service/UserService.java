package vn.iotstar.demo_sitemesh_thymeleaf.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstar.demo_sitemesh_thymeleaf.entity.UserInfo;
import vn.iotstar.demo_sitemesh_thymeleaf.repository.UserInfoRepository;
@Service
public record UserService(UserInfoRepository repository, 
		PasswordEncoder passwordEncoder) {
	public String addUser(UserInfo userInfo)
	{
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Thêm user thành công!";
	}

}
