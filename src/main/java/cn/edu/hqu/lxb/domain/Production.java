package cn.edu.hqu.lxb.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor   //提供全参的构造方法
@NoArgsConstructor		//提供无参的无参的构造方法
public class Production {
	@Getter
	@Setter
	long id;
	@Getter
	@Setter
	@NotEmpty
	String proid;
	@Getter
	@Setter
	@NotEmpty
	String username;

	
	
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
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{authord.size}")
	private String authord; 
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{proname.size}")
	private String proname;
	
	
	
	
	@Getter
	@Setter

	private String status;
	
	
	@Getter
	@Setter

	private String date;
	
	
	
	
	
	
	@Getter
	@Setter
	private MultipartFile pic;
	
	
	
}
