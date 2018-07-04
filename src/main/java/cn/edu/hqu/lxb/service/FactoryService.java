package cn.edu.hqu.lxb.service;


import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Factory;




@Service
public interface FactoryService {
	public Factory login(String userName,String password);
	public boolean register(Factory factory);
	public Factory getUserDetail(String userName);
}
