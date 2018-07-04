package cn.edu.hqu.lxb.service;

import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Retailer;



@Service
public interface RetailerService {
	public Retailer login(String userName,String password);
	public boolean register(Retailer retailer);
	public Retailer getUserDetail(String userName);
}
