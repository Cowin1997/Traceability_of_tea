package cn.edu.hqu.lxb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.edu.hqu.lxb.domain.Retailer;
import cn.edu.hqu.lxb.repository.RetailerRepository;
import cn.edu.hqu.lxb.service.RetailerService;
@Service
public class RetailerServiceImpl implements RetailerService {
    
	 @Autowired
	 RetailerRepository RetailerRepository;
	@Override
	public Retailer login(String userName, String password) {
		Retailer retailer;
	if((retailer=RetailerRepository.findByUsername(userName))!=null 
		&& retailer.getPassword().equals(password)) {
		System.out.println(retailer.getUserName());
		return retailer;		
	}
	else
		return null;
	}

	@Override
	public boolean register(Retailer retailer) {
		if(RetailerRepository.findByUsername(retailer.getUserName())==null) {
			RetailerRepository.save(retailer);
			return true;
		}
		return false;
	}

	@Override
	public Retailer getUserDetail(String userName) {
		return RetailerRepository.findByUsername(userName);
	}

}
