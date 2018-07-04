package cn.edu.hqu.lxb.service;



import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Production;

@Service
public interface ProductionService {
	public boolean  revise (Production production);
	public int getproductionnum(String proname);
	public void save(Production production);
	public void savedetail(String proid);
	public Production findByBig(String proid);
	public Production findBySmall(String sid);
	public List<Production>findProdByUserName(String username);
	public void updatePro(String name,String proid,Production production);
}
