package cn.edu.hqu.lxb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor   //提供全参的构造方法
@NoArgsConstructor		//提供无参的无参的构造方法
public class RetailerProd {
	@Getter
	@Setter
	long id;
	
	
	@Getter
	@Setter
    String userName;
	
	@Getter
	@Setter
	String proid;
	
	@Getter
	@Setter
	String detailid;
	
	@Getter
	@Setter
	String proname;
	
	@Getter
	@Setter
	String proaddr;
	
	@Getter
	@Setter
	String status;
	
	@Getter
	@Setter
	String datein;
	
	@Getter
	@Setter
	String datesell;
	
	
}
