package cn.edu.hqu.lxb.toolutils;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ProIdTool {
	 /**
	  * 
	  * <br>功能：<B>获取18位唯一码</B>
	  * <br>思路： 用时间戳加上4位随机数生成
	  * <OL>
	  *   <LI>1、</LI>
	  *   <LI>2、</LI>
	  *   <LI>3、</LI>
	  * </OL>
	  * <br>相关性：
	  * @return
	  */
	 public static String getRandomID() {
	  //1、创建时间戳
	  java.util.Date dateNow = new java.util.Date();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	  String dateNowStr = dateFormat.format(dateNow);
	  StringBuffer sb = new StringBuffer(dateNowStr);

	  //2、创建随机对象
	  Random rd = new Random(); 
	  
	  //3、产生4位随机数
	  String n = "";
	  int rdGet; //取得随机数

	  do {
	   rdGet = Math.abs(rd.nextInt()) % 10 + 48; //产生48到57的随机数(0-9的键位值)
	   // rdGet=Math.abs(rd.nextInt())%26+97; //产生97到122的随机数(a-z的键位值)
	   char num1 = (char) rdGet;
	   String dd = Character.toString(num1);
	   n += dd;
	  } while (n.length() < 4);// 假如长度小于4
	  sb.append(n);
	  
	  //4、返回唯一码
	  return sb.toString();
	 }
	}

