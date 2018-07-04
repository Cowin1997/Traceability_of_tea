package cn.edu.hqu.lxb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Factory;
import cn.edu.hqu.lxb.repository.FactoryRepository;
import cn.edu.hqu.lxb.service.FactoryService;
@Service
public class FactoryServiceImpl implements FactoryService{
	@Autowired
	FactoryRepository factoryrepository;

	@Override
	public Factory login(String userName, String password) {
		// TODO Auto-generated method stub

		Factory factory;
		if((factory=factoryrepository.findByUserName(userName))!=null 
				&& factory.getPassword().equals(password)) {
			System.out.println(factory.getUserName());
			return factory;
			
		}
		return null;
	}

	@Override
	public boolean register(Factory factory) {
		if((factoryrepository.findByUserName(factory.getUserName()))==null) {
			factoryrepository.save(factory);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Factory getUserDetail(String userName) {
		// TODO Auto-generated method stub
		return factoryrepository.findByUserName(userName);
	}
	
	
}
