package cn.edu.hqu.lxb;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DatabaseTest1Application {
  //   搴旇鎶婂惎鍔� springboot鐨勫寘璁剧疆涓洪《鍖�
	public static final String ROOT = "D:\\pics";
	public static void main(String[] args) throws IOException {
		File file=new File(ROOT);
		if(!file.exists()) {
			file.mkdir();
		}
		File directory = new File("");// 鍙傛暟涓虹┖
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
		SpringApplication.run(DatabaseTest1Application.class, args);
	}
}
