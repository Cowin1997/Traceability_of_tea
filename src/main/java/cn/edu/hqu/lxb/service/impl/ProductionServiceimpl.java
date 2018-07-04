package cn.edu.hqu.lxb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.repository.ProductionRepository;
import cn.edu.hqu.lxb.service.ProductionService;
@Service
public class ProductionServiceimpl implements ProductionService {
 @Autowired
 	ProductionRepository productionrepository;
	@Override
	public boolean revise(Production production) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getproductionnum(String proname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(Production production) {
		productionrepository.save(production);
		
	}

	@Override
	public void savedetail(String proid) {
		productionrepository.savedetail(proid);
		
	}

	@Override
	public Production findByBig(String proid) {
		return productionrepository.findByProductionId(proid);
	}

	@Override
	public Production findBySmall(String sid) {
		return productionrepository.findBigBySmall(sid);
		
	}

	@Override
	public List<Production> findProdByUserName(String username) {
		// TODO Auto-generated method stub
		return  productionrepository.findByUserName(username);
	}

	@Override
	public void updatePro(String name, String proid, Production production) {
		productionrepository.updatePro(name, proid, production);
	}

}
