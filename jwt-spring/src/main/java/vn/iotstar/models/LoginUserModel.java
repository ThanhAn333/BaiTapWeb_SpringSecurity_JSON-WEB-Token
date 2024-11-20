package vn.iotstar.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUserModel {

	private String email;
	
	private String password;
}
