package vn.iotstar.demo_sitemesh_thymeleaf.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.iotstar.demo_sitemesh_thymeleaf.entity.UserInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private List<GrantedAuthority>authorities;
	
    private UserInfo userInfo;

    // Constructor nhận tham số UserInfo
    public UserInfoUserDetails(UserInfo userInfo) {
        name = userInfo.getName();
        password = userInfo.getPassword();
        authorities = Arrays.stream(userInfo.getRoles().split(","))
        		.map(SimpleGrantedAuthority::new)
        		.collect(Collectors.toList());
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	public boolean isCredentialNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled()
	{
		return true;
	}

    // Các getter/setter hoặc phương thức khác
}


