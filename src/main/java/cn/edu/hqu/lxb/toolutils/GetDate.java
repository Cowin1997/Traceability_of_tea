package cn.edu.hqu.lxb.toolutils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static String getDate(){
	    Date now = new Date();  
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        String date = format.format(now.getTime());//这个就是把时间戳经过处理得到期望格式的时间 
		
		return date;
	}
	public static String getEmptyDate() {
		return "0000-00-00";
	}
}
