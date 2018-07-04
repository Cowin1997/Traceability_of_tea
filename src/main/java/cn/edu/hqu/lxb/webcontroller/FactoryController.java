package cn.edu.hqu.lxb.webcontroller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.edu.hqu.lxb.DatabaseTest1Application;
import cn.edu.hqu.lxb.domain.Factory;
import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.loginuser.LoginUser;
import cn.edu.hqu.lxb.service.FactoryService;
import cn.edu.hqu.lxb.service.ProductionService;
import cn.edu.hqu.lxb.toolutils.GetDate;
import cn.edu.hqu.lxb.toolutils.ProIdTool;
import cn.edu.hqu.lxb.toolutils.Sell;


@Controller
@RequestMapping("/factory")
public class FactoryController {
	@Autowired
	FactoryService factoryservice;
	
	
	@Autowired
	ProductionService productionservice;
	
	
	
	@RequestMapping(value="/factory_register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Factory());
		return "factory_register";
	}
	
	@RequestMapping(value="/factory_register",method=RequestMethod.POST)
	public String processRegister(@Valid Factory factory,Errors errors,RedirectAttributes model) throws IOException {
		if(errors.hasErrors())
			return "factory_register";
		else  if (!factoryservice.register(factory)) {
			errors.rejectValue("userName", "User has exist!");
			return "factory_register";
		}
		else {
		//	Files.copy(hquer.getPic().getInputStream(), Paths.get(Chapter71Application.ROOT, hquer.getUserName()+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
			model.addFlashAttribute(factory);
			return "redirect:/factory/"+factory.getUserName();
		}
			
	}
	
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String factoryProfile(@PathVariable String userName,Model model) {
		if(!model.containsAttribute("factory")) {
			Factory factory=factoryservice.getUserDetail(userName);
			model.addAttribute(factory);
		}
		return "factory_detail";
	}
	
	
	
	@RequestMapping(value="/factory_login",method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new LoginUser());
		return "factory_login";
		
	}
	
	@RequestMapping(value="/factory_login",method=RequestMethod.POST)
	public String processLogin(@Valid LoginUser user,Errors erros,RedirectAttributes model) {
		Factory factory;
		if((factory=factoryservice.login(user.getUserName(), user.getPassword()))==null)
			return "factory_login";
		
		model.addFlashAttribute(factory);
		return "redirect:/factory/"+factory.getUserName();
	}
	
	
	@RequestMapping(value="/factory_production_commit",method=RequestMethod.GET)
	public String ProCommitGet(@RequestParam(value="name") String username,Model model,HttpSession session)  {
		session.setAttribute("name", username);
		model.addAttribute("name",username);
		model.addAttribute(new Production());
		return "factory_production_commit";
			
	}
	
	@RequestMapping(value="/factory_production_commit",method=RequestMethod.POST)
	public String ProCommitPost(@Valid Production production,BindingResult bindingresult,RedirectAttributes model,HttpSession session) throws IOException  {
		//Files.copy(production.getPic().getInputStream(), Paths.get(DatabaseTest1Application.ROOT, production.getProname()+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
		String username = (String)session.getAttribute("name");
		System.out.println(username);
		
		
		File directory = new File("");// 
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
		Files.copy(production.getPic().getInputStream(), 
		Paths.get(courseFile+"\\src\\main\\resources\\static", production.getProname()+".jpeg")
		,StandardCopyOption.REPLACE_EXISTING);
	//	production.setPicurl(courseFile+"\\src\\main\\resources\\static\\");
		String id =ProIdTool.getRandomID();
		production.setUsername(username);
		production.setProid(id);
		production.setStatus(Sell.NOTSHELL);
		production.setDate(GetDate.getDate());
		System.out.println(ProIdTool.getRandomID());
		productionservice.save(production);
		productionservice.savedetail(id);
		model.addFlashAttribute(production);
		model.addAttribute("name", username);
		return "commit_detail";	
	}
	
	@RequestMapping(value="/factory_production_setail",method=RequestMethod.GET)
	public String GetProlist(@RequestParam(value="name") String username,Model model) {
		System.out.println(username);
		List<Production>list = productionservice.findProdByUserName(username);
		
		model.addAttribute("prolist",list);
		model.addAttribute("name",username);
	//	model.addAttribute("status", "");

		return "factory_production_setail";
		
	}
	
	@RequestMapping(value="/factory_production_revise",method=RequestMethod.GET)
	public String ProReviseGET(@RequestParam(value="name") String username,@RequestParam(value="id")String id,Model model) {
		
		System.out.println(username+","+id);
		model.addAttribute("name",username);
		model.addAttribute("id", id);
		model.addAttribute(new Production());
		return "factory_production_revise";
		
	}
	@RequestMapping(value="/factory_production_revise",method=RequestMethod.POST)
	public String ProRevisePOST(@RequestParam(value="name") String username,@RequestParam(value="id")String id,@Valid Production production,BindingResult bindingresult,Model model) {
		System.out.println(production.getProname());
		
		
		productionservice.updatePro(username, id, production);

		return"redirect:/factory/factory_production_setail?name="+username;
		
	}

}
