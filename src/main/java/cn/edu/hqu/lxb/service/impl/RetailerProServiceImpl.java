package cn.edu.hqu.lxb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.Retailer;
import cn.edu.hqu.lxb.domain.RetailerProd;
import cn.edu.hqu.lxb.repository.RetailerProRepository;
import cn.edu.hqu.lxb.service.RetailerProService;
import cn.edu.hqu.lxb.service.RetailerService;

@Service
public class RetailerProServiceImpl implements RetailerProService{
	@Autowired
	RetailerProRepository RetailerProRepository;

	@Override
	public void save(RetailerProd retailerprod) {
		RetailerProRepository.save(retailerprod);
		
	}

	@Override
	public List<RetailerProd> findProductByUsername(String username) {
		
		return RetailerProRepository.findByUsername(username);
	}

	

	@Override
	public void ProdInBySmall(String detailid,String name) {
		RetailerProRepository.ProdInBySmall(detailid, name);
		
	}

	@Override
	public void ProdInByBig(String proid, String name) {
		RetailerProRepository.ProdInByBig(proid, name);
		
	}

	@Override
	public void update(String username, String id) {
		RetailerProRepository.update(username, id);
		
	}

	@Override
	public RetailerProd findByDetailid(String detailid) {
		// TODO Auto-generated method stub
		return RetailerProRepository.findByDetailid(detailid);
	}


}
