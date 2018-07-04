package cn.edu.hqu.lxb.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor   //提供全参的构造方法
@NoArgsConstructor		//提供无参的无参的构造方法
public class Retailer {
	@Getter
	@Setter
	private long id;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=5,max=16,message="{userName.size}")
	private String userName;
	
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{password.size}")
	private String password;
	
	
	
	@Getter
	@Setter
	@NotEmpty
	@Email(message="{email.valid}")
	private String email;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{retailername.size}")
	private String retailername;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{retaileraddr.size}")
	private String retaileraddr;
	
	
	
}
