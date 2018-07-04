package cn.edu.hqu.lxb.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor   //提供全参的构造方法
@NoArgsConstructor		//提供无参的无参的构造方法
public class Factory {
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
	@Size(min=4,max=25,message="{factoryname.size}")
	private String factoryname;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{factoryaddr.size}")
	private String factoryaddr;
	/*
	@Getter
	@Setter
	private MultipartFile pic;
	*/
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "username","factoryname","factoryaddr","password","email");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "username","factoryname","factoryaddr","password","email");
	}
	
}
