package cn.edu.hqu.lxb.webcontroller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.Retailer;
import cn.edu.hqu.lxb.domain.RetailerProd;
import cn.edu.hqu.lxb.domain.inquiry;
import cn.edu.hqu.lxb.service.ProductionService;
import cn.edu.hqu.lxb.service.RetailerProService;
import cn.edu.hqu.lxb.service.RetailerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ProductionService productionservice;
	@Autowired
	RetailerProService RetailerProService;
	@Autowired
	RetailerService RetailerService;
	
	@RequestMapping(value="/inquiry",method=RequestMethod.GET)
	public String doinquiry(Model model) {
		model.addAttribute(new inquiry());
		System.out.println("拦截到inquiry请求");
		return "inquiry";
	}

	@RequestMapping(value="/inquiry_result",method=RequestMethod.POST)
	public String doinquiryresult(@Valid inquiry inquiry,Production production,Model model) {
		System.out.println("返回inquiry请求");
		if(inquiry.getInquiryid().equals("")||inquiry.getInquiryid().length()!=18)
			return "inquiry";
		
		if(productionservice.findByBig(inquiry.getInquiryid())!=null) {	
			System.out.println("查询的号码属于大包");
			production = productionservice.findByBig(inquiry.getInquiryid());
			model.addAttribute(production);
			Retailer retailer=new Retailer();
			retailer.setRetaileraddr("");
			retailer.setRetailername("");
			RetailerProd retailerprod =new RetailerProd();
			retailerprod.setStatus("");
			retailerprod.setDatesell("");
			model.addAttribute(retailerprod); 
			model.addAttribute(retailer);
			return "inquiry_result";
	
		}
		
		
		if(productionservice.findBySmall(inquiry.getInquiryid())!=null) {
			System.out.println("查询的号码属于小包");
			model.addAttribute(productionservice.findBySmall(inquiry.getInquiryid()));
			RetailerProd retailerprod=RetailerProService.findByDetailid(inquiry.getInquiryid());
			production = productionservice.findBySmall(inquiry.getInquiryid());
			model.addAttribute(production);
		//	model.addAttribute("status",RetailerProService.findByDetailid(inquiry.getInquiryid()).getStatus());
			
			if(retailerprod!=null) {
			model.addAttribute(retailerprod);
			
			Retailer retailer=RetailerService.getUserDetail(retailerprod.getUserName());
			
			if(retailer!=null)
			model.addAttribute(retailer);
			else {
				retailer=new Retailer();
				retailer.setRetaileraddr("");
				retailer.setRetailername("");
				model.addAttribute(retailer);
			}
	
			}
		
			else if(retailerprod==null) {
				retailerprod=new RetailerProd();
				retailerprod.setStatus("");
				retailerprod.setDatesell("");
				model.addAttribute(retailerprod);
				Retailer retailer=new Retailer();
				retailer.setRetaileraddr("");
				retailer.setRetailername("");
				model.addAttribute(retailer);
			}
			
	
				return "inquiry_result";
			
		}
		
		
		System.out.println("找不到！");
		return "inquiry";
		
	//	return "inquiry_result";
	}

}
