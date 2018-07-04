package cn.edu.hqu.lxb.loginuser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
	@Getter
	@Setter
	String userName;
	@Getter
	@Setter
	String password;
}
