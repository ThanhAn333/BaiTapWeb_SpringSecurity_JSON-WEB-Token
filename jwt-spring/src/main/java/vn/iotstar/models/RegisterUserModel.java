package vn.iotstar.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserModel {
	
	private String email;
	
	private String password;
	
	private String fullName;
	
	private String images;

}
