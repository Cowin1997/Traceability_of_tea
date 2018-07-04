package cn.edu.hqu.lxb.webcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.Retailer;
import cn.edu.hqu.lxb.domain.RetailerProd;
import cn.edu.hqu.lxb.domain.inquiry;
import cn.edu.hqu.lxb.loginuser.LoginUser;
import cn.edu.hqu.lxb.service.ProductionService;
import cn.edu.hqu.lxb.service.RetailerProService;
import cn.edu.hqu.lxb.service.RetailerService;





@Controller
@RequestMapping("/retailer")
public class RetailerController {
	@Autowired
	RetailerProService RetailerProService;
	@Autowired
	ProductionService ProductionService;
	@Autowired
	RetailerService RetailerService;
	@RequestMapping(value="/retailer_register",method=RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute(new Retailer());
		return "retailer_register";
	}
	
	@RequestMapping(value="/retailer_register",method=RequestMethod.POST)
	public String processRegister(@Valid Retailer retailer,Errors errors,RedirectAttributes model) throws IOException {
		if(errors.hasErrors())
			return "retailer_register";
		else  if (!RetailerService.register(retailer)) {
			errors.rejectValue("userName", "username exist!");
			return "retailer_register";
		}
		else {
		
			model.addFlashAttribute(retailer);
			return "redirect:/retailer/"+retailer.getUserName();
		}
			
	}
	
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String factoryProfile(@PathVariable String userName,Model model) {
		if(!model.containsAttribute("retailer")) {
			Retailer retailer=RetailerService.getUserDetail(userName);
			model.addAttribute(retailer);
			
		}
		return "retailer_detail";
	}
	
	
	
	@RequestMapping(value="/retailer_login",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new LoginUser());
		return "retailer_login";
		
	}
	
	@RequestMapping(value="/retailer_login",method=RequestMethod.POST)
	public String processLogin(@Valid LoginUser user,Errors erros,RedirectAttributes model) {
		Retailer retailer;
		if((retailer=RetailerService.login(user.getUserName(), user.getPassword()))==null)
			return "retailer_login";
		
		model.addFlashAttribute(retailer);
		return "redirect:/retailer/"+retailer.getUserName();
	}

	@RequestMapping(value="/retailer_prodin",method=RequestMethod.GET)
	public String getProIn(@RequestParam(value="name") String username,Model model,HttpSession session) {
	//	System.out.println(username);
		session.setAttribute("user", username);
		inquiry inquiry=new inquiry();
		model.addAttribute(inquiry);
		return "retailer_prodin";
	}
	
	@RequestMapping(value="/retailer_prodin_result",method=RequestMethod.POST)
	public String GetProInResult(@Valid inquiry inquiry,Model model,HttpSession session) {
		String name = (String) session.getAttribute("user");
		String id   = inquiry.getInquiryid();
		System.out.println(name);
		System.out.println(id);
		Production production=new Production();
		//通过大包的方式，进货，一个大包进货包含10个小包
		if(ProductionService.findByBig(id)==null) {
			System.out.println("输出的产品不存在");
			return "retailer_prodin";
		}
		if(ProductionService.findByBig(id)!=null) {
		RetailerProService.ProdInByBig(id, name);
		production=ProductionService.findByBig(id);
		}/*
		 if(ProductionService.findBySmall(id)!=null) {
			RetailerProService.ProdInBySmall(id, name);	
			production=ProductionService.findBySmall(id);
		 }
		 */
		 model.addAttribute(production);
		model.addAttribute("name",name);
		return "retailer_prodin_result";
	}
	
	
@RequestMapping(value="/retailer_pro_info",method=RequestMethod.GET)
	public String ShowProInfo(@RequestParam(value="name")String username,Model model) {
	List<RetailerProd>list =RetailerProService.findProductByUsername(username);
//	System.out.println(list.size());
	model.addAttribute("prolist",list);
	model.addAttribute("name",username);
	 
	return "retailer_pro_info";
	}

@RequestMapping(value="/retailer_pro_sell",method=RequestMethod.GET)
	public String ProSell(@RequestParam(value="name")String username,@RequestParam(value="id")String id) {
	
	System.out.println(username);
	System.out.println(id);
	//List<RetailerProd>list =RetailerProService.findProductByUsername(username);
	RetailerProService.update(username, id);
	return "redirect:/retailer/retailer_pro_info?name="+username;
}


}
