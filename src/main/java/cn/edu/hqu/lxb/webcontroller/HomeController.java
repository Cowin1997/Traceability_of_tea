package cn.edu.hqu.lxb.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({"/","index"})
	public String home() {
		System.out.println("get home ");
		return "home";
	}
}
