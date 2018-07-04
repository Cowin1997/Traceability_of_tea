package cn.edu.hqu.lxb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor   //提供全参的构造方法
@NoArgsConstructor		//提供无参的无参的构造方法
public class inquiry {
	@Getter
	@Setter
	String inquiryid;
	@Getter
	@Setter
	String proid;
	@Getter
	@Setter
	String name;

}
